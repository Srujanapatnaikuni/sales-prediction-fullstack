package sales_prediction_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import sales_prediction_backend.entity.Prediction;
import sales_prediction_backend.repository.PredictionRepository;

@RestController
@CrossOrigin(origins = "*")
public class PredictionController {

    private final RestTemplate restTemplate;
    private final PredictionRepository predictionRepository;

    public PredictionController(PredictionRepository predictionRepository) {
        this.restTemplate = new RestTemplate();
        this.predictionRepository = predictionRepository;
    }

    @PostMapping("/predict")
    public ResponseEntity<?> predict(@RequestBody PredictionRequest request) {

        String mlServiceUrl = "http://localhost:5000/predict";

        Map<String, Object> response = restTemplate.postForObject(
                mlServiceUrl,
                request,
                Map.class
        );

        double predictedSales =
                ((Number) response.get("predicted_sales")).doubleValue();

        Prediction prediction = new Prediction(
                request.getTv(),
                request.getRadio(),
                request.getNewspaper(),
                predictedSales
        );

        predictionRepository.save(prediction);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/predictions")
    public List<Prediction> getPredictions() {
        return predictionRepository.findAll();
    }
}