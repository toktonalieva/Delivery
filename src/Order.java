public class Order {
    private int id;
    private Customer customer;
    private FoodItem[] items;
    private OrderStatus status;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new FoodItem[0];
        this.status = OrderStatus.NEW;
    }

    public int getId() { return id; }
    public OrderStatus getStatus() { return status; }


    public void addItem(FoodItem item) {
        FoodItem[] newItems = new FoodItem[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[items.length] = item;
        this.items = newItems;
    }

    public void printOrder() {
        System.out.println("=========================================");
        System.out.println("Заказ ID: " + id + " | Статусу: " + status);
        customer.printInfo();
        System.out.println("Тамактардын тизмеси:");
        for (FoodItem item : items) {
            System.out.print("  - ");
            item.printInfo();
        }
        System.out.println("Жалпы суммасы: " + calculateTotal() + " сом");
        System.out.println("Арзандатуу менен: " + calculateTotalWithDiscount() + " сом");
        System.out.println("=========================================");
    }


    public void changeStatus(OrderStatus status) {
        this.status = status;
        System.out.println("Заказ ID " + id + " статусу өзгөрдү: " + status);
    }


    public void removeItem(int itemId) {
        int indexToRemove = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == itemId) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            FoodItem[] newItems = new FoodItem[items.length - 1];
            int remainingIndex = 0;
            for (int i = 0; i < items.length; i++) {
                if (i != indexToRemove) {
                    newItems[remainingIndex++] = items[i];
                }
            }
            this.items = newItems;
            System.out.println("ID " + itemId + " болгон тамак заказтан өчүрүлдү.");
        } else {
            System.out.println("ID " + itemId + " тамак табылган жок.");
        }
    }


    public double calculateTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double calculateTotalWithDiscount() {
        double total = 0;
        for (FoodItem item : items) {
            double discount = 0;
            if (item instanceof Discountable) { // Полиморфизм
                discount = ((Discountable) item).calculateDiscount();
            }
            total += (item.getPrice() - discount);
        }
        return total;
    }

    public int getItemCount() {
        return items.length;
    }

    public FoodItem findMostExpensiveItem() {
        if (items.length == 0) {
            return null;
        }
        FoodItem mostExpensive = items[0];
        for (FoodItem item : items) {
            if (item.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = item;
            }
        }
        return mostExpensive;
    }
}
