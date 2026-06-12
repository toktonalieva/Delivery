public class DeliveryService {
    private String serviceName;
    private Order[] orders;

    public DeliveryService(String serviceName) {
        this.serviceName = serviceName;
        this.orders = new Order[0];
    }

    public void addOrder(Order order) {
        Order[] newOrders = new Order[orders.length + 1];
        System.arraycopy(orders, 0, newOrders, 0, orders.length);
        newOrders[orders.length] = order;
        this.orders = newOrders;
    }

    public void printAllOrders() {
        System.out.println("\n--- БАРДЫК ЗАКАЗДАР (" + serviceName + ") ---");
        for (Order order : orders) {
            order.printOrder();
        }
    }

    public Order findOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) return order;
        }
        return null;
    }

    public void deleteOrder(int id) {
        int index = -1;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Order[] newOrders = new Order[orders.length - 1];
            int k = 0;
            for (int i = 0; i < orders.length; i++) {
                if (i != index) newOrders[k++] = orders[i];
            }
            this.orders = newOrders;
            System.out.println("Заказ ID " + id + " тутумдан өчүрүлдү.");
        }
    }

    public void findDeliveredOrders() {
        System.out.println("\n--- ЖЕТКИРИЛГЕН ЗАКАЗДАР ---");
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DELIVERED) order.printOrder();
        }
    }

    public void findCancelledOrders() {
        System.out.println("\n--- ЖОК КЫЛЫНГАН ЗАКАЗДАР ---");
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.CANCELLED) order.printOrder();
        }
    }

    public double calculateTotalRevenue() {
        double revenue = 0;
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DELIVERED) {
                revenue += order.calculateTotalWithDiscount();
            }
        }
        return revenue;
    }
}

