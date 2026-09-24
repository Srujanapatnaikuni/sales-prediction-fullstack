package sales_prediction_backend.controller;

public class PredictionResponse {

    private double predicted_sales;

    public PredictionResponse(double predicted_sales) {
        this.predicted_sales = predicted_sales;
    }

    public double getPredicted_sales() {
        return predicted_sales;
    }

    public void setPredicted_sales(double predicted_sales) {
        this.predicted_sales = predicted_sales;
    }
}