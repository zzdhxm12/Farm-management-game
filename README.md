# SimFarm
 Farm management game
 
 동물농장을 구성, 각종 동물들을 잘 키워 직접 판매하거나 부산물(계란, 우유 등)을 판매하고 능력치를 향상시켜 경진대회에서 우승하는 기능을 포함한 프로그램 

## Architecture
* 프로그램 구조  
![image](https://user-images.githubusercontent.com/53864655/72232888-60819f00-3607-11ea-85ad-d25f3ed5ee9a.png)


* 상세 구조

![image](https://user-images.githubusercontent.com/53864655/72232899-6ecfbb00-3607-11ea-98b7-903ee1e5fe9f.png)


* 절차 설계 

![image](https://user-images.githubusercontent.com/53864655/72232904-78f1b980-3607-11ea-962e-cc73b150b995.png)



## Usecase

### 1. 메인 

![image](https://user-images.githubusercontent.com/53864655/71707814-fb23f600-2e2f-11ea-840b-9dde524ade7e.png)

* 버튼 4개(새로 시작, 이어 하기, 게임 방법, 게임 종료), 텍스트 필드 1개(닉네임 입력), 라벨 2개(닉네임, 제목) 사용

### 2. 게임 설명

![image](https://user-images.githubusercontent.com/53864655/71708029-9bc6e580-2e31-11ea-8d07-ccad520474c6.png)

* 게임 방법 패널 생성

### 3. 새로 시작 버튼 클릭 시

![image](https://user-images.githubusercontent.com/53864655/71708043-b1d4a600-2e31-11ea-9dc3-4a9c28779dae.png)

* 닉네임을 입력하고, 새로 시작 버튼을 클릭하면 "닉네임 (사용자 입력)으로 게임을 시작합니다." 팝업 창 생성

### 4. 새로 시작 시, 사용자 패널 

![image](https://user-images.githubusercontent.com/53864655/71708050-c1ec8580-2e31-11ea-8471-ae955c78dc68.png)

* 4개 버튼(게임 시작, 엔딩보관함, 설정, 메인으로) 사용 
* 설정에서 닉네임 변경 가능

### 5. 게임 시작 클릭 시 (초기 게임)

![image](https://user-images.githubusercontent.com/53864655/71708060-d4ff5580-2e31-11ea-9432-6f3e03c05a77.png)

* 2가지 경우를 선택할 수 있는 선택 창 생성

### 6. 엔딩 획득

![image](https://user-images.githubusercontent.com/53864655/71708063-e47e9e80-2e31-11ea-81c2-6606e9be6241.png)

* 5번 화면에서 첫 번째 경우를 선택한 경우, 파산 엔딩 획득

### 7. 엔딩 보관함

![image](https://user-images.githubusercontent.com/53864655/71708073-f3655100-2e31-11ea-8462-33a149017c3f.png)

* 엔딩 보관함에 엔딩이 추가되면 해당 엔딩 다시 보기 가능

### 8. 메인 게임

![image](https://user-images.githubusercontent.com/53864655/71708087-0710b780-2e32-11ea-8fe4-2b91e8f52ad4.png)

* 하단에 7개 버튼(은행, 상점, 내 동물, 창고, 공방, 콘테스트, 종료) 사용
* 상단에 유저 정보, 시간 표시
* 게임 시간 1분 = 실제 시간 3초

### 9. 은행

![image](https://user-images.githubusercontent.com/53864655/71708095-17c12d80-2e32-11ea-9d83-2a682691b4be.png)

* 빚 갚기와 대출 가능

### 10. 상점 - 동물
* 동물 구입 : 구입을 원하는 동물 클릭 시, 구매 확인 후 이름 입력 창 생성

### 11. 상점 - 사료/기타
* 사료/기타 구입 : 구매를 원하는 아이템을 클릭 시, 구매 확인 후 구입 확정

### 12. 상점 - 로또 
* 6개의 숫자 입력 후 구매하기 버튼 클릭 시, 메세지 창으로 로또 결과 표시

### 13. 동물 활동
* 구입한 동물이 메인 게임 화면에서 동물이 양 옆으로 움직임

### 14. 도움말
* 도움말 버튼 클릭 시, 상세 도움말 표시

### 15. 
