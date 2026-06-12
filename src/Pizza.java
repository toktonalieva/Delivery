public class Pizza extends  FoodItem implements Discountable{
    private String size;

    public Pizza(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }


    @Override
    public void prepare() {
        System.out.println("Пицца '" + getName() + "' (" + size + ") бышырылып жатат.");
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Size: " + size +
                " 10% скидка.");
    }
}
