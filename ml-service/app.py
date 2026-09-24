from flask import Flask, request, jsonify
import pickle
import os

app = Flask(__name__)

# Load trained model
with open("sales_model.pkl", "rb") as file:
    model = pickle.load(file)


@app.route("/")
def home():
    return "Sales Prediction ML API is running"


@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()

    tv = data["tv"]
    radio = data["radio"]
    newspaper = data["newspaper"]

    prediction = model.predict([[tv, radio, newspaper]])

    return jsonify({
        "predicted_sales": float(prediction[0])
    })


if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host="0.0.0.0", port=port)