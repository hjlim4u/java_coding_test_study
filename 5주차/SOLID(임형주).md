로버트C.마틴이 처음 발표한 객체지향 설계 원칙

## S(Single responsibility principle)
하나의 클래스는 단 하나의 책임만 가져야한다.
하나의 목표만을 위한 클래스를 작성한다면 애플리케이션 모듈 전반에서 높은 유지보수성(비즈니스 로직)과 가시성 제어(캡슐화)를 유지

## O(Open closed principle)
소프트웨어 컴포넌트는 확장에 관해 열려 있어야 하고 수정에 관해서는 닫혀 있어야 한다는 사실을 의미합니다. 
클래스는 다른 개발자가 작업을 수행하기 위해 반드시 수정해야 하는 제약 사항을 클래스에 포함X
단순히 클래스를 확장하기만 해도 클래스의 동작을 수정할 수 있도록 설계 및 작성

#### 개방-폐쇄 원칙을 따르지 않는 경우  
```java
public interface Shape {}  
public class Rectangle implements Shape {
 private final int width;
 private final int height;  

// 생성자와 getter는 생략
}
public class Circle implements Shape {
	private final int radius;
}
```
면적의 합을 구하는 클래스
```java
public class AreaCalculator {
	private final List<Shape> shapes;
	public AreaCalculator(List<Shape> shapes) {
		this.shapes = shapes;
	}

	//도형을 추가하려면 이 클래스를 수정 개방 패쇄 원칙에 위반
	public double sum() {
		int sum = 0;
		for (Shape shape : shapes) {
			if (shape.getClass().equals(Circle.class)) {
				sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
			} else if (shape.getClass().equals(Rectangle.class)) {
				sum += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
			}
		}
		return sum;
	}
}
```
새로운 도형 추가하고 싶으면 새로운 if 문을 추가하기 위해 AreaCalculator 클래스 수정

#### 개방-폐쇄 원칙을 따르는 경우
면적 계산 공식: AreaCalculator -> 각 Shape 클래스
```java
public interface Shape {
	public double area();
}

public class Rectangle implements Shape {
	private final int width;
	private final int height;

	@Override
	public double area() {
		return width * height;
	}
}

public class Circle implements Shape {
	public final int radius;
	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
}
```
면적 합 구하는 클래스
```java
public class AreaCalculator {
	private final List<Shape> shapes;

	public double sum() {
		int sum = 0;
		for (Shape shape: shapes) {
			sum += shape.area();
		}
		return sum;
	}
}
```

## L(Liskov substitution principle)
파생 타입은 반드시 기본 타입을 완벽하게 대체할 수 있어야 한다
서브 클래스의 객체와 슈퍼클래스의 객체가 반드시 같은 방식으로 동작

### 리스코프 치환 원칙 따르지 않는 경우
Member 클래스 모든 구성원을 나타내는 추상 클래스

```java
public abstract class Member {
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public abstract void joinTournament();
    public abstract void organizeTournament();
}'
```

```java
public class PremiumMember extends Member {
    public PremiumMember(String name) {
        super(name);
    }
        
    @Override
    public void joinTournament() {
        System.out.println("Premium member joins tournament ...");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Premium member organize tournament ...");
    }
}
```

```java
public class FreeMember extends Member {
    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Classic member joins tournament ...");
    }

    // 이 메서드는 무료 회원이 토너먼트를 개최할 수 없으므로
    // 리스코프 치환 원칙에 맞지 않습니다. 기본 클래스를 대체할 수 없습니다.
    @Override
    public void organizeTournament() {
        System.out.println("A free member cannot organize tournaments");
    }
}
```
무료회원은 organizeTournament 메소드 지원 X, 기본 클래스 대체 불가

### 리스코프 치환 원칙 따르는 경우
참가하고 주최하는 두 가지 일을 두개의 인터페이스로 분리
```java
public interface TournamentJoiner {
    public void joinTournament();
}
```

```java
public interface TournamentOrganizer {
    public void organizeTournament();
}
```
```java
public abstract class Member implements TournamentJoiner, TournamentOrganizer {
    private final String name;

    public Member(String name) {
        this.name = name;
    }  
}
```

```java
public class FreeMember implements TournamentJoiner {
    private final String name;

    public FreeMember(String name) {
        this.name = name;
    }

    @Override
    public void joinTournament() {
        System.out.println("Free member joins tournament ...");
    }
}
```

```java
List<TournamentJoiner> members2 = List.of(
          new PremiumMember("Jack Hores"),
          new VipMember("Tom Johns"),
          new FreeMember("Martin Vilop")
        )
```
```java
List<TournamentOrganizer> members3 = List.of(
          new PremiumMember("Jack Hores"),
          new VipMember("Tom Johns")
        );
```

## I(Interface segregation principle)
클라이언트가 사용하지 않을 불필요한 메서드를 강제로 구현하게 해서는 안됨
클라이언트가 사용하지 않을 메서드를 강제로 구현하는 일이 없을 때까지 인터페이스를 2개 이상의 인터페이스로 분리

#### 인터페이스 분리 원칙을 따르지 않는 경우
```java
public interface Connection {
    public void socket();
    public void http();
    public void connect();
}
```

```java
public class WwwPingConnection implements Connection {
    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http() {
        System.out.println("Setup an HTTP connection to " + www);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + www);
    }

    // 이 구현은 인터페이스 분리 원칙에 맞지 않습니다. 이 클래스는 socket 메서드가 필요하지 않지만 강제로 재정의해야 합니다.
    @Override
    public void socket() { }
}
```

### 인터페이스 분리 원칙을 따르는 경우
```java
public interface Connection {
    public void connect();//모든 클라이언트에 필요
}
```

```java
public interface HttpConnection extends Connection {
    public void http();
}
```

```java
public interface SocketConnection extends Connection {
    public void socket();
}
```

```java
public class WwwPingConnection implements HttpConnection {
    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http() {
        System.out.println("Setup an HTTP connection to " + www);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + www);
    } 
}
```

## D(Dependency inversion principle)
구체화가 아닌 추상화에 의존해야 한다.
다른 구상 모듈에 의존하는 대신, 구상 모듈을 결합하기 위해 추상 계층에 의존해야 한다.
구상 모듈은 분리된 상태를 유지하면서 다른 구상 모듈의 기능 또는 플러그인 확장 가능

### 의존관계 역전 원칙을 따르지 않는 경우
```java
public class PostgreSQLJdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    public String get() {
        return "jdbc:postgresql:// ... " + this.dbName;
    }
}
```

```java
public class ConnectToDatabase {
    public void connect(PostgreSQLJdbcUrl postgresql) {
        System.out.println("Connecting to " + postgresql.get());
    }
}
```

### 의존관계 역전 원칙을 따르는 경우
```java
public interface JdbcUrl {
    public String get();
}
```

```java
public class PostgreSQLJdbcUrl implements JdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String get() {
        return "jdbc:postgresql:// ... " + this.dbName;
    }
}
```
```java
public class ConnectToDatabase {
    public void connect(JdbcUrl jdbcUrl) {
        System.out.println("Connecting to " + jdbcUrl.get());
    }
}
```