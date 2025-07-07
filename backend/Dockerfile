FROM python:3.12-slim
WORKDIR /code
RUN pip install fastapi uvicorn[standard]
COPY app.py .
CMD ["uvicorn", "app:app", "--host", "0.0.0.0", "--port", "5000"]
