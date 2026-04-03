# fitness-BE-server

체력 입력, 처방 저장, 시설 데이터 조회, AI 추천 연동을 담당하는 Spring Boot 백엔드 서버입니다.  
MySQL 기반 도메인 데이터를 관리하고, 필요 시 FastAPI AI 서버와 Kakao 주소 검색을 연결해 통합 추천 응답을 구성합니다.

## Deployment

- AWS EC2에 배포해 운영
- AI 서버와 프론트엔드와는 분리된 레포지토리/배포 단위

## Overview

- Spring Boot 기반 REST API
- MySQL + JPA 사용
- FastAPI AI 서버 연동
- Kakao 주소 좌표 변환 연동
- 운동 처방, 시설, 입력값 관련 도메인 API 제공

## Tech Stack

- Java 17
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring WebFlux
- Spring Cloud OpenFeign
- MySQL
- Gradle

## Project Structure

```text
src/main/java/com/hamin/sports/fitnessapi/
  domain/
    exercisemapping/
    facility/
    prescription/
    recommend/
    userinput/
  global/
src/main/resources/application.yml
```

## Local Configuration

기본 설정 파일은 `src/main/resources/application.yml`입니다.

현재 코드 기준 기본값:

- Server Port: `8080`
- MySQL URL: `jdbc:mysql://localhost:3306/fitnessdb`
- MySQL User: `root`
- AI Server URL: `http://localhost:8000`

주의:

- `application.yml`에는 로컬 개발용 값이 들어 있습니다.
- 배포 전에는 DB 계정, Kakao API 키 같은 민감정보를 환경변수 또는 별도 설정으로 분리하는 것을 권장합니다.

## Run

Windows:

```bash
.\gradlew.bat bootRun
```

테스트:

```bash
.\gradlew.bat test
```

## Main Endpoints

- `GET /health`
  - 헬스 체크
- `POST /api/userinput`
  - 사용자 입력 저장
- `POST /api/recommend/fitness`
  - AI 서버에 운동 추천을 요청하고 시설 추천 결과를 병합
- `GET /api/facilities`
  - 전체 시설 조회
- `GET /api/facilities/region?sido=...&sigungu=...`
  - 지역별 시설 조회
- `GET /api/facilities/category/{category}`
  - 카테고리별 시설 조회
- `POST /api/facilities`
  - 시설 데이터 저장
- `GET /api/prescriptions`
  - 처방 조회
- `POST /api/prescriptions`
  - 처방 저장
- `GET /api/exercise-mapping`
  - 운동 매핑 조회
- `GET /api/exercise-mapping/prescription/{id}`
  - 특정 처방 기준 운동 매핑 조회
- `POST /api/exercise-mapping`
  - 운동 매핑 저장

## Recommend Flow

`POST /api/recommend/fitness` 동작 순서:

1. 사용자 입력을 FastAPI AI 서버로 전달
2. AI 서버에서 유사 사용자 기반 운동 추천 생성
3. 백엔드에서 Kakao API로 주소를 좌표로 변환
4. 좌표와 운동 종목을 다시 AI 시설 추천 API로 전달
5. 운동 추천 + 시설 추천 결과를 하나의 응답으로 반환

## Example Request

```json
{
  "userInput": {
    "age": 27,
    "sex": "F",
    "height": 165,
    "weight": 58
  },
  "facility": {
    "address": "서울특별시 강남구 테헤란로 212",
    "facilityType": "public",
    "distanceLimit": 10
  }
}
```

## Development Notes

- 추천 서비스는 현재 `http://localhost:8000`의 AI 서버 실행을 전제로 합니다.
- 운영 환경에서는 백엔드 서버를 AWS EC2에 배포해 사용합니다.
- 프론트엔드 프로젝트의 현재 구현은 이 백엔드를 직접 사용하지 않고 AI 서버를 직접 호출합니다.
- 통합 API를 프론트에 연결하려면 프론트의 API base URL을 이 서버 기준으로 조정하면 됩니다.
