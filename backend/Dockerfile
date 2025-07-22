# --- build 단계 ---
FROM node:20-alpine AS build
WORKDIR /app
COPY backend/package*.json ./
RUN npm ci
COPY backend/ .
# --- run 단계 ---
FROM node:20-alpine
WORKDIR /app
COPY --from=build /app /app
EXPOSE 5000
CMD ["npm","start"]
