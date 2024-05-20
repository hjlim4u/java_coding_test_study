#### Map이란 키(Key)와 값(Value)의 쌍으로 데이터를 저장하는 자료구조입니다. 각 키는 고유해야 하며, 키를 사용하여 해당하는 값을 검색, 삽입, 삭제할 수 있습니다. 자바에서 Map은 인터페이스로 다양한 방식으로 이러한 키-값을 저장하고 관리합니다.

- HashMap
- TreeMap
- LinkedHashMap
- ConcurrentHashMap




# 1. HashMap
   - 가장 많이 쓰이는 구현방식으로 해싱을 사용하여 많은 양의 데이터를 검색하는데 뛰어난 성능을 보입니다.
   - 보통 HashTable 과 비교를 하는데 HashTable 과 HashMap의 관계는 Vector와 ArrayList의 관계와 비슷합니다.
   - 둘다 해싱을 이용한 자료구조지만 HashTable 은 기본적으로 스레드 안전합니다. 모든 메서드가 동기화되어 있어, 멀티스레드 환경에서 안전하게 사용할 수 있습니다. 하지만 Vector와 마찬가지로 사용을 권장하진 않습니다.
   - HashMap은 동기화 오버헤드가 없기 때문에, HashTable보다 성능이 더 좋습니다.
   - 중복을 허용하지 않기 때문에 같은 키에 다른 값을 넣으면 나중에 넣은 값이 적용됩니다.
   - 중복은 두 객체의 equals()가 true가 나오고 hashCode()의 값이 같아야 같은 객체로 봅니다.
   - HashMap<K, V> map = new HashMap<>(); 으로 구현한다.
   ## 메소드
   - Object put(Object key, Object value): 지정된 키와 값을 저장
   - Object get(Object key): 지정된 키에 해당하는 값을 반환, 못찾으면 null 반환
   - void clear(): map의 모든 객체 삭제
   - boolean containsKey(Object key): 지정된 키가 있는지 알려준다.
   - boolean containsValue(Object value): 지정된 값이 있는지 알려준다.
   - Set entrySet(): 모든 키값이 들어있는 set 반환
   - boolean isEmpty(): 비어있는지 반환
   - Object remove(Object key): 지정된 키 삭제
   - int size(): 키, 값 쌍의 갯수 반환
   - Object replace(Object key, Object value): 지정된 키의 값을 지정된 값으로 변환


# 2. TreeMap
   - 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장합니다.
   - 보통 검색 성능은 HashMap이 좋기때문에 HashMap을 사용하는게 좋습니다.
   - 하지만 정렬이 필요하거나 범위검색이 필요한 경우에는 TreeMap을 사용합니다.
   - TreeMap<K, V> map = new TreeMap();
   ## 메소드
   - Map.Entry ceilingEntry(Object key): 지정된 키와 같거나 큰것중에서 가장 작은것의 키와 값을 가진 쌍을 반환, 없으면 null
   - Object ceilingKey(Object key): 지정된 키와 같거나 큰것중에서 가장 작은것의 키를 반환, 없으면 null
   - Map.Entry floorEntry(Object key): 지정된 키와 같거거나 작은 것중에서 가장 큰 키의 쌍을 반환, 없으면 null
   - Object floorKey(Object key): 지정된 키와 같거나 작은 것중에서 가장 큰 키를 반환, 없으면 null
   - Map.Entry higherEntry(Object key):  지정된 키보다 큰 것중에서 가장 작은 키의 쌍을 반환, 없으면 null
   - Object higherKey(Object key):  지정된 키보다 큰 것중에서 가장 작은 키를 반환, 없으면 null
   - Map.Entry lowerEntry(Object key): 지정된 키보다 작은 것중에서 가장 큰 키의 쌍을 반환, 없으면 null
   - Object lowerKey(Object key): 지정된 키보다 작은 것중에서 가장 큰 키를 반환, 없으면 null
   - Map.Entry firstEntry(): 가장 첫번째의 키와 값의 쌍을 반환
   - Object firstKey(): 가장 첫번째 키를 반환
# 3. LinkedHashMap
   - LinkedHashMap은 기본적으로 HashMap과 동일하지만 Map에 입력된 순서를 기억하는 자료구조다. 사용법은 HashMap과 동일하다.

# 4. ConcurrentHashMap
   - HashTable 클래스의 단점을 보완하면서 멀티 스레드 환경에서 사용할 수 있도록 나온 클래스입니다. 
   - HashTable, HashMap, ConcurrentHashMap은 Map의 기능적으로만 보면 큰 차이는 없습니다. 
   - ConcurrentHashMap은 읽기 작업에는 여러 쓰레드가 동시에 읽을 수 있지만, 쓰기 작업에는 특정 세그먼트 or 버킷에 대한 락을 사용합니다.