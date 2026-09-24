package sales_prediction_backend.controller;

public class PredictionRequest {

    private double tv;
    private double radio;
    private double newspaper;

    public double getTv() {
        return tv;
    }

    public void setTv(double tv) {
        this.tv = tv;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(double newspaper) {
        this.newspaper = newspaper;
    }
}