# SOLID
## 좋은 객체 지향 설계의 5가지 원칙



### SRP: 단일 책임 원칙(Single responsibility principle)

### OCP: 개방-폐쇄 원칙(Open/closed principle)

### LSP: 리스코프 치환 원칙(Liskov substitution principle)

### ISP: 인터페이스 분리 원칙(Interface segregation principle)

### DIP: 의존관계 역전 원칙(Dependency inversion principle)





## SRP 단일 책임 원칙
### Single responsibility principle
- 한 클래스는 하나의 책임만 가져야 한다.
- 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른것
- 변경이 필요할 때 수정할 대상이 명확해진다.




## OCP 개방-폐쇄 원칙
### Open/closed principle
- 소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야 한다.
- 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 한다는 원칙을 말한다.
- 다형성
- 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현


## LSP 리스코프 치환 원칙
# Liskov substitution principle
- 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
- 다형성을 지원하기 위한 원칙
- 부모 클래스 자리에 자식 클래스를 넣어서 단순히 컴파일에 성공하는 것을 넘어서 기능적으로 유사해야 한다.
- 예를 들어, 부모 클래스 자동차가 앞으로 가는 기능을 자식은 뒤로 가게 구현하면 LSP 위반, 느리더라도 앞으로 가야함


## ISP 인터페이스 분리 원칙
# Interface segregation principle
- 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
- 목적과 관심이 각기 다른 클라이언트가 있다면 인터페이스를 통해 적절하게 분리해줄 필요가 있다.
- 인터페이스가 명확해지고, 대체 가능성이 높아진다.


## DIP 의존관계 역전 원칙
# Dependency inversion principle
- 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안 되며, 저수준 모듈이 고수준 모듈에 의존해야 한다는 것이다.
- 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻