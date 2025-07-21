# 1) 베이스 이미지
FROM python:3.10-slim

# 2) 작업 디렉토리
WORKDIR /app

# 3) 전체 컨텍스트(코드)를 가져오기
COPY . .

# 4) 백엔드 의존성 설치
#    backend/requirements.txt 파일이 이 시점에 존재해야 합니다.
RUN pip install --no-cache-dir -r backend/requirements.txt

# 5) (선택) streamlit 의존성도 설치하려면:
# RUN pip install --no-cache-dir -r streamlit/requirements.txt

# 6) 포트 노출
EXPOSE 8000

# 7) 애플리케이션 시작
CMD ["python", "backend/app.py"]
