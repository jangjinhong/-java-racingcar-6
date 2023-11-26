# 우아한 프리코스 2주차 미션 - 자동차 경주

---
<br><br>
## 패키지 목록 (폴더 구조)

---
![img.png](img.png)
- controller
  - RacingCarController : 전반적인 프로그램 흐름을 컨트롤
- entity
  - Car : 입력받은 각각의 자동차 개체로, 게임 참여자로 취급 됨
  - Game : 게임 참여자가 참여하는 게임의 흐름을 담당
- service
  - CarService : Car가 수행할 기능을 담당
  - GameService : Game이 수행할 기능을 담당
- view
  - InputView : 입력받기 위한 안내문 출력
  - OutputView : 게임을 진행하기 위한 안내문 출력
  - ValidatorOutputView : 예외 처리에 대한 안내문 출력

<br>

## 🚀 기능 목록

---
초간단 자동차 경주 게임을 구현한다.
1. 자동차 이름은 쉼표(,)를 기준으로 구분되며 이름은 5자 이하만 가능하다.
2. 사용자는 몇 번의 이동을 할 것인지 입력해야 한다.
3. 주어진 횟수 동안 n대의 자동차는 '전진' 또는 '멈춤'을 수행한다. 
   수행 기준은 0-9 까지의 정수 중 무작위로 반환 되는 한 개의 정수이다.
4. 자동차 **전진** 조건은 0-9 까지의 정수 중 추출된 하나의 *무작위 값이 4 이상* 일 경우이다.
5. 자동차 **멈춤** 조건은 0-9 까지의 정수 중 추출된 하나의 *무작위 값이 3 이하* 일 경우이다.
6. 자동차 경주 게임을 완료한 후 우승자를 발표한다. 우승자는 한 명 이상일 수 있으며 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

**프로그램**
- 자동차 경주 게임 흐름 안내
- 무작위 값이 4 이상일 경우 '전진' 수행
- 무작위 값이 3 이하일 경우 '멈춤' 수행
- 주어진 게임 실행 횟수에 따른 게임 진행 과정 출력
- 자동차 경주 게임 완료 후 우승결과 안내

**사용자**
- 자동차 n대의 이름 입력
- 게임 실행 횟수 입력

**예외처리**
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료

<br><br>
### 정상 입/출력 예시

---

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

#### 정상 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

