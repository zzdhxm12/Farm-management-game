# SimFarm
 Farm management game
 
 동물농장을 구성, 각종 동물들을 잘 키워 직접 판매하거나 부산물(계란, 우유 등)을 판매하고 능력치를 향상시켜 경진대회에서 우승하는 기능을 포함한 프로그램 

## Architecture

### 1. 프로그램 구조도

![image](https://user-images.githubusercontent.com/53864655/72240635-12c95e80-3628-11ea-9bb4-95af702aef5e.png)

### 2. 절차 설계 

![image](https://user-images.githubusercontent.com/53864655/72240714-46a48400-3628-11ea-935a-4a2c33e3e55c.png)


## Usecase

### 1. 메인 

![image](https://user-images.githubusercontent.com/53864655/72232960-dbe35080-3607-11ea-9df5-8b8506a4ed3f.png)

* 버튼 4개(새로 시작, 이어 하기, 게임 방법, 게임 종료), 텍스트 필드 1개(닉네임 입력), 라벨 2개(닉네임, 제목) 사용

### 2. 게임 설명

![image](https://user-images.githubusercontent.com/53864655/72232966-e4d42200-3607-11ea-86b8-639d23aea80a.png)

* 게임 방법 패널 생성

### 3. 새로 시작 버튼 클릭 시

![image](https://user-images.githubusercontent.com/53864655/72233017-24027300-3608-11ea-9f84-05413c80dea8.png)

* 닉네임을 입력하고, 새로 시작 버튼을 클릭하면 "닉네임 (사용자 입력)으로 게임을 시작합니다." 팝업 창 생성

### 4. 새로 시작 시, 사용자 패널 

![image](https://user-images.githubusercontent.com/53864655/72233019-282e9080-3608-11ea-9cbf-1030fbb01466.png)

* 4개 버튼(게임 시작, 엔딩보관함, 설정, 메인으로) 사용 
* 설정에서 닉네임 변경 가능

### 5. 엔딩보관함(초기 상태)

![image](https://user-images.githubusercontent.com/53864655/72233102-9c693400-3608-11ea-858d-21c95ccf2789.png)

* 초기 게임의 엔딩보관함은 비어있음

### 6. 게임 시작 클릭 시 (초기 상태)

![image](https://user-images.githubusercontent.com/53864655/72233122-b6a31200-3608-11ea-825b-ea36d09dc256.png)

* 게임 시나리오 나레이션

![image](https://user-images.githubusercontent.com/53864655/72233136-c884b500-3608-11ea-9cb6-4ffeab1a99e1.png)

* 시나리오 나레이션 후, 2가지 선택지 등장

### 7. 엔딩 획득 (파산)

![image](https://user-images.githubusercontent.com/53864655/72233192-1bf70300-3609-11ea-80af-49355262a675.png)

* 선택지에서 "농장을 팔아 돈을 마련한다."를 선택한 경우, 파산 엔딩 획득

### 8. 엔딩 보관함 (파산 엔딩 보유 중)

![image](https://user-images.githubusercontent.com/53864655/72233208-4052df80-3609-11ea-95ba-230eb226eb9d.png)

* 엔딩 보관함에 엔딩이 추가되면 해당 엔딩 다시 보기 가능

### 9. 메인 게임

![image](https://user-images.githubusercontent.com/53864655/72233224-62e4f880-3609-11ea-8c94-a8d08bbf83e4.png)

* 하단에 7개 버튼(은행, 상점, 내 동물, 창고, 공방, 콘테스트, 종료) 사용
* 상단에 유저 정보, 시간 표시
* 게임 시간 1분 = 실제 시간 3초

### 10. 은행

![image](https://user-images.githubusercontent.com/53864655/72233228-6aa49d00-3609-11ea-8a74-6a8e6eac6b30.png)

* 빚 갚기와 대출 가능

### 11. 상점 - 동물

![image](https://user-images.githubusercontent.com/53864655/72233237-74c69b80-3609-11ea-9105-62f02b805791.png)

* 동물 구입 : 구입을 원하는 동물 클릭 시, 구매 확인 후 이름 입력 창 생성

### 12. 상점 - 사료/기타

![image](https://user-images.githubusercontent.com/53864655/72233239-7728f580-3609-11ea-8589-4974d9e66f74.png)

* 사료/기타 구입 : 구매를 원하는 아이템을 클릭 시, 구매 확인 후 구입 확정

### 13. 상점 - 로또 

![image](https://user-images.githubusercontent.com/53864655/72233244-798b4f80-3609-11ea-97a5-a7c9129b8c4f.png)

* 6개의 숫자 입력 후 구매하기 버튼 클릭 시, 메세지 창으로 로또 결과 표시

### 14. 동물 활동

![image](https://user-images.githubusercontent.com/53864655/72233245-7beda980-3609-11ea-989e-2d2a95b32a64.png)

* 구입한 동물이 메인 게임 화면에서 동물이 양 옆으로 움직임

### 15. 도움말

![image](https://user-images.githubusercontent.com/53864655/72233248-7db76d00-3609-11ea-8834-288de47e1001.png)

* 도움말 버튼 클릭 시, 상세 도움말 표시

### 16. 내 동물

![image](https://user-images.githubusercontent.com/53864655/72233252-7f813080-3609-11ea-9ae2-9fc6128f20eb.png)

* 상점에서 구입한 동물을 차례로 화면에 출력

### 17. 내 동물 상세 보기

![image](https://user-images.githubusercontent.com/53864655/72233255-81e38a80-3609-11ea-8074-e474630c13a9.png)

* 동물의 상세 정보 출력 (이름, 성격, 능력치, 체력)
* 하트 주기, 먹이 주기, 팔기, 약 먹이기, 이름 바꾸기 가능

### 18. 동물 판대

![image](https://user-images.githubusercontent.com/53864655/72233337-12ba6600-360a-11ea-9323-3b5bdb0108a4.png)

* 내 동물 상세 보기(**17**)에서 동물 판매 시, 내 동물(**16**)에서 판매한 동물 사라짐

### 19. 창고

![image](https://user-images.githubusercontent.com/53864655/72233339-15b55680-360a-11ea-8686-939c32139f8f.png)

* 기본적으로 게임 내 존재하는 아이템이 그림으로 출력되고 사용자가 가지고 있는 아이템의 개수가 라벨로 표시

### 20. 공방

![image](https://user-images.githubusercontent.com/53864655/72233340-1817b080-360a-11ea-97d5-1ae3bfe67670.png)

* 다양한 재료들을 다른 아이템으로 제작 가능

### 21. 콘테스트

* 내가 가진 동물의 능력치 등의 종합적인 정보를 통해 다른 동물들과 경쟁

![image](https://user-images.githubusercontent.com/53864655/72233342-1cdc6480-360a-11ea-9205-0c740815979d.png)

* 사용자 레벨 15 이상만 참여 가능

![image](https://user-images.githubusercontent.com/53864655/72233344-1e0d9180-360a-11ea-9411-ff15dce8f750.png)

* 현재 내가 가진 동물 출력

![image](https://user-images.githubusercontent.com/53864655/72233347-206feb80-360a-11ea-92e8-47d6a457310e.png)

* 콘테스트에 내보낼 동물 선택

![image](https://user-images.githubusercontent.com/53864655/72233350-2239af00-360a-11ea-8024-9e712896bb4e.png)

* 콘테스트 결과 출력
