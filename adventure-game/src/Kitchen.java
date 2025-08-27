public class Kitchen extends Room {

    private final Item[] items = {
            new Item("Выдвижной ящик", "Верхний ящик под столешницей")
    };

    public Kitchen(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    Kitchen(String name) {
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
