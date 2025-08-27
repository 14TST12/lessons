public class Bathroom extends Room {

    private final Item[] items = {
            new Item("Зеркало", "Круглое зеркало над раковиной"),
            new Item("Раковина", "Белая керамическая раковина"),
    };

    public Bathroom(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public Bathroom(String name) {
        this(name, "");
    }

    @Override
    public void printItems() {
        System.out.print("Предметы в комнате " + this.getName() +": ");
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i].getName());
            if(i<items.length-1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }
    }
}
