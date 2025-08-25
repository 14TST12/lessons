public class Bedroom extends Room {

    private final Item[] items = {
            new Item("Окно", "Окно с ручкой в дальней стене"),
            new Item("Тумбочка", "Деревянная тумбочка у кровати"),
            new Item("Кровать", "Незаправленная кровать из Икеи")
    };

    public Bedroom(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public Bedroom(String name) {
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
