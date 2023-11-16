
# 절차 및 요구사항

- [x] 날짜를 입력받는다.

- [x] 날짜를 생성한다.
  - [x] 날짜는 1이상 31 이하이어야 한다.

- [x] 메뉴와 개수들을 입력받는다.
  - [x] 각 메뉴와 개수는 쉼표 단위로 구분한다.
  - [x] 메뉴와 개수는 대시 단위로 구분한다.

- [x] 주문을 생성한다.
  - [x] 존재하는 메뉴이어야 한다.
  - [x] 메뉴의 개수는 1 이상이어야 한다.

- [x] 주문 목록을 생성한다.
  - [x] 입력 메뉴가 중복되지 않아야 한다.
  - [x] 음료만 주문할 수 없다.
  - [x] 메뉴는 최대 20개까지 주문 가능하다.

- [x] 증정 이벤트를 계산한다.
  - [x] 이벤트는 총 주문 금액이 1만원 이상일 때 적용한다.
  - [x] 할인 전 주문 금액이 12만원 이상 적용, 샴페인을 증정한다.

- [x] 적용 가능한 할인들을 구한다.
  - [x] 이벤트는 총 주문 금액이 1만원 이상일 때 적용한다.
  - [x] 1일~25일이라면, 크리스마스 디데이 할인을 구한다.
  - [x] 일~목요일이라면, 평일 할인을 구한다.
  - [x] 금~토요일이라면, 주말 할인을 구한다.
  - [x] 매주 일요일 또는 크리스마스라면, 특별 할인을 구한다.

- [x] 적용 가능한 할인들을 계산한다.
  - [x] 크리스마스 디데이 할인은 1000원부터 시작해서, 25일에 가까워질 때마다 100원씩 추가할인한다.
  - [x] 평일 할인이라면, 디저트 메뉴 1개당 2023원 할인한다.
  - [x] 주말 할인이라면, 메인 메뉴 1개당 2023원 할인한다.
  - [x] 특별 할인이라면, 1000원 할인한다.

- [x] 뱃지 이벤트를 계산한다.
  - [x] 이벤트는 총 주문 금액이 1만원 이상일 때 적용한다.
  - [x] 혜택 금액 5천원 이상 적용, 별을 증정한다.
  - [x] 혜택 금액 1만원 이상 적용, 트리를 증정한다.
  - [x] 혜택 금액 2만원 이상 적용, 산타를 증정한다.

- [x] 주문 메뉴를 출력한다.
- [x] 할인 전 총액을 출력한다.
- [x] 증정 메뉴를 출력한다.
- [x] 적용된 이벤트와 할인액을 출력한다.
- [x] 총 혜택 금액을 출력한다.
- [x] 할인 후 예상 결제 금액을 출력한다.
- [x] 12월 이벤트 뱃지를 출력한다.

# 객체 목록

## constant

### Badge
- NOTHING
- STAR
- TREE
- SANTA
- static Badge findBadge(int discounted)
- String getBadgeName()

### Calender
- BEFORE_CHRISTMAS
- CHRISTMAS
- WEEKDAY
- WEEKEND
- SUNDAY
- boolean verify(int day)

### Course
- APPETIZER
- MAIN
- DESSERT
- DRINK

### ExceptionMessage
- INVALID_ORDER_MESSAGE
- INVALID_TODAY_MESSAGE

### Menu
- MUSHROOM_SOUP
- TAPAS
- CAESAR_SALAD
- T_BONE_STEAK
- BARBEQUE_RIBS
- SEAFOOD_PASTA
- CHRISTMAS_PASTA
- CHOCO_CAKE
- ICE_CREAM
- ZERO_COKE
- RED_WINE
- CHAMPAGNE
- static Menu getMenu(String name)
- String getMenuName()
- int getPrice()
- boolean is(Course course)

### MessageJoiner
- EMPTY
- EXIST
- static String join(List\<String> strings)

## controller

### ChristmasController
- void play()

## domain

### Today
- boolean is(Calender calender)
- int getToday()

### Discount

#### Discount
- String getMessage()
- int getDiscountedPrice()
- @Override void equals()
- @Override void hashcode()

#### Discounts
- String getDiscountsMessage()
- int getTotalDiscountedPrice()

### Giveaway

#### Giveaway
- String getMessage()
- @Override void equals()
- @Override void hashcode()

#### Giveaways
- getGiveawayMessage()

### Order

#### Order
- String getMessage()
- int getPrice()
- int getCount()
- Menu getMenu()
- boolean is(Course course)

#### Orders
- String getOrderedMenusMessage()
- int getTotalPrice()
- int getCourseCount(Course course)

### Event

#### Event
- static void validatePrice(int price)

#### DiscountEvent extends Event
- Discount getDiscount()

#### GiveawayEvent extends Event
- Giveaway getGiveaway()

#### Events
- Discounts getTotalDiscounts()
- Giveaways getGiveaways()
- Discounts getDiscountsExceptGiveaways()

#### EventsBuilder
- EventsBuilder today(Today today)
- EventsBuilder orders(Orders orders)
- Events build()

#### ChampagneGiveawayEvent implements DiscountEvent, GiveawayEvent
- static Event createInstance(int totalPrice)
- Discount getDiscount()
- Giveaway getGiveaway()

#### ChristmasDDayEvent implements DiscountEvent
- static Event createInstance(Today today, Orders orders)
- Discount getDiscount()

#### WeekdayEvent implements DiscountEvent
- static Event createInstance(Today today, Orders orders)
- Discount getDiscount()

#### WeekendEvent implements DiscountEvent
- static Event createInstance(Today today, Orders orders)
- Discount getDiscount()

#### SpecialEvent implements DiscountEvent
- static Event createInstance(Today today, Orders orders)
- Discount getDiscount()

## Service

### TodayService
- Today createToday(String today)

### OrderService
- Orders createOrders(String ordersString)
- Order createOrder(String orderString)

## View

### InputView
- String getToday()
- String getOrders()

### OutputView
- void printHeader()
- void printIllegalArgumentException(IllegalArgumentException e)
- void printEventPreviewMessage()
- void printOrderedMenus(String orderedMenus)
- void printTotalPriceBeforeDiscount(int totalPrice)
- void printGiveaway(String giveawayMessage)
- void printDiscountMessage(String discountMessage)
- void printTotalDiscounts(int totalDiscounts)
- void printTotalPriceAfterDiscount(int discountedTotalPrice)
- void printBadge(String badgeName)