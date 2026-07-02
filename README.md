# ✈️ [Scoula] ( Travel & Community Hub)

> **[한 줄 소개]** 여행지 추천부터 유저 간 소통(게시판, 갤러리)까지 제공하는 종합 여행 커뮤니티 웹 서비스입니다.

<br/>

## 📌 주요 기능 (Key Features)

캡슐화 및 모듈화된 라우팅 구조를 바탕으로 다음의 기능들을 제공합니다.

* **🔒 Auth (인증 및 인가)**
  * `login`, `logout`: JWT/세션 기반 사용자 로그인 및 로그아웃
  * `join`: 신규 회원 가입 및 유효성 검사
* **📝 Board (게시판)**
  * 자유로운 의견 및 정보 공유를 위한 커뮤니티 게시판 (CRUD 기능)
  * 페이징 처리 및 검색 기능
* **🗺️ Travel (여행지 추천)**
  * 테마별/지역별 추천 여행지 정보 제공
  * 상세 보기 및 여행지 위치 정보 안내
* **🖼️ Gallery (갤러리)**
  * 여행 사진 업로드 및 공유 기능
  * 이미지 썸네일 제공 및 그리드 뷰 형태의 UI

<br/>

## 🛠 기술 스택 (Tech Stack)

### Frontend
* **Framework:** Vue 3 (Composition API)
* **Build Tool:** Vite
* **Routing & State:** Vue Router, Pinia
* **HTTP Client:** Axios

### Backend
* **Framework:** Spring Boot [버전]
* **Language:** Java [버전]
* **Database:** MySQL
* **ORM / DB Access:**  MyBatis

<br/>

## 📁 프로젝트 구조 (Project Structure)

```text
📦 [프로젝트 최상위 폴더]
 ┣ 📂 backend       # Spring Boot 서버 로직 및 API 구현
 ┃ ┣ 📂 src/main/java/org/...
 ┃ ┗ 📜 build.gradle (또는 pom.xml)
 ┗ 📂 frontend      # Vue 3 기반 클라이언트 UI 구현
   ┣ 📂 src
   ┃ ┣ 📂 components
   ┃ ┣ 📂 pages
   ┃ ┗ 📂 router    # 기능별 라우팅 모듈화 (auth, board, travel, gallery)
   ┗ 📜 package.json
