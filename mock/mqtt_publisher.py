import time, json, random, paho.mqtt.publish as pub
BROKER = "localhost"
while True:
    data = {"current": round(random.uniform(1.1, 3.3), 2)}
    pub.single("factory/line1", json.dumps(data), hostname=BROKER, port=1883)
    print("sent:", data)
    time.sleep(5)
