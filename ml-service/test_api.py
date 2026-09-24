print("TEST STARTED")

import requests

print("Requests imported")

data = {
    "tv": 150,
    "radio": 30,
    "newspaper": 20
}

print("Sending request...")

response = requests.post(
    "http://127.0.0.1:5000/predict",
    json=data
)

print("Response received")
print(response.status_code)
print(response.json())