//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    DeliveryService deliveryService = new DeliveryService("Yandex Go");

    Pizza p1 = new Pizza(101, "Маргарита", 500, "SMALL");
    Pizza p2 = new Pizza(102, "Пепперони", 750, "MEDIUM");
    Pizza p3 = new Pizza(103, "Төрт сыр", 900, "LARGE");

    Burger b1 = new Burger(201, "Чизбургер", 250, true);
    Burger b2 = new Burger(202, "Гамбургер", 220, false);
    Burger b3 = new Burger(203, "Блэк Бургер", 350, true);

    Customer customer1 = new Customer(1, "Алихан Асанов", "+996700112233");
    Customer customer2 = new Customer(2, "Айпери Маматова", "+996555443322");


    Order order1 = new Order(5001, customer1);
    Order order2 = new Order(5002, customer2);

    order1.addItem(p2);
    order1.addItem(b1);
    order1.addItem(p1);

    order2.addItem(p3);
    order2.addItem(b3);

    deliveryService.addOrder(order1);
    deliveryService.addOrder(order2);


    order1.changeStatus(OrderStatus.DELIVERED);
    order2.changeStatus(OrderStatus.PREPARING);

    System.out.println("\n--- Өчүрүүгө чейинки тамактардын саны: " + order1.getItemCount());
    order1.removeItem(101);
    System.out.println("Өчүрүлгөндөн кийинки тамактардын саны: " + order1.getItemCount());

    System.out.println("\nЗаказ 1 Жалпы суммасы: " + order1.calculateTotal() + " сом");
    System.out.println("Заказ 1 Арзандатуу менен: " + order1.calculateTotalWithDiscount() + " сом");

    FoodItem expensive = order1.findMostExpensiveItem();
    if (expensive != null) {
        System.out.println("Заказ 1 ичиндеги эң кымбат тамак: " + expensive.getName() + " (" + expensive.getPrice() + " сом)");
    }

    deliveryService.printAllOrders();

    System.out.println("Жеткирилген заказдардан түшкөн жалпы киреше: " + deliveryService.calculateTotalRevenue() + " сом");
}

