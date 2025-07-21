# 1) 베이스 이미지: 가볍고 안정적인 Python 3.10
FROM python:3.10-slim

# 2) 작업 디렉토리
WORKDIR /app

# 3) 백엔드 의존성만 예시로 설치
#    필요하다면 streamlit, MQTT 클라이언트 등도 추가
COPY backend/requirements.txt ./requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# 4) 애플리케이션 코드 복사
COPY backend ./backend
# (필요하다면 다른 폴더도 복사)
# COPY streamlit ./streamlit

# 5) 컨테이너 외부에 노출할 포트 (예: 백엔드 8000번)
EXPOSE 8000

# 6) 애플리케이션 시작 명령
#    예시: backend/app.py 가 메인 서버 스크립트라 가정
CMD ["python", "backend/app.py"]
