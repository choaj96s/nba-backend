#!/bin/bash
set -e

# 1) ECR URL
ECR_URL="997754089670.dkr.ecr.us-west-2.amazonaws.com"

# 2) 작업 디렉토리
cd /home/ec2-user

# 3) AWS ECR 로그인 (EC2 IAM Role로 가능하면 없어도 되지만 안전하게 넣음)
aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin $ECR_URL

# 4) 최신 이미지 pull
docker pull $ECR_URL/nba-backend:latest

# 5) docker-compose.yml 생성/업데이트
cat > docker-compose.yml << 'EOF'
version: "3.8"
services:
  backend:
    image: 997754089670.dkr.ecr.us-west-2.amazonaws.com/nba-backend:latest
    ports:
      - "8080:8080"
EOF

# 6) 컨테이너 실행
docker-compose up -d
