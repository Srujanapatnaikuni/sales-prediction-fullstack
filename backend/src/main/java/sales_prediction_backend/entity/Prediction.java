package sales_prediction_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "predictions")
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tv;
    private double radio;
    private double newspaper;
    private double predictedSales;

    public Prediction() {
    }

    public Prediction(double tv, double radio, double newspaper, double predictedSales) {
        this.tv = tv;
        this.radio = radio;
        this.newspaper = newspaper;
        this.predictedSales = predictedSales;
    }

    public Long getId() {
        return id;
    }

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

    public double getPredictedSales() {
        return predictedSales;
    }

    public void setPredictedSales(double predictedSales) {
        this.predictedSales = predictedSales;
    }
}
