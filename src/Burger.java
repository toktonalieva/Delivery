public class Burger extends FoodItem implements  Discountable{
    private boolean hasCheese;

    public Burger(int id, String name, double price, boolean hasCheese) {
        super(id, name, price);
        this.hasCheese = hasCheese;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public void prepare() {
        System.out.println("Бургерге котлет  кошулду");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Сыр барбы: " + (hasCheese ? "Ооба" : "Жок") + " 5% скидка");
    }
}
