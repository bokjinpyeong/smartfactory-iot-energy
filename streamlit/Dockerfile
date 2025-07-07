FROM python:3.12-slim
WORKDIR /app
RUN pip install streamlit
COPY app.py .
ENTRYPOINT ["streamlit", "run", "app.py", "--server.port=8501", "--server.address=0.0.0.0"]
