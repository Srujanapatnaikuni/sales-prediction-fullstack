package sales_prediction_backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sales_prediction_backend.entity.Prediction;
public interface PredictionRepository extends JpaRepository<Prediction, Long> {
}