# SmartFactory IoT Energy

## Stack
- **Backend** : Node.js + Express (포트 5000)
- **MQTT Broker** : Eclipse Mosquitto (1883 / 9001)
- **Database** : MySQL 8
- **Dashboard** : Grafana (3000)

## Local run
```bash
docker compose up --build
#   http://localhost:5000/health
#   http://localhost:3000  (Grafana)
