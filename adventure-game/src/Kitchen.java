public class Kitchen extends Room {

    public Kitchen(String name, String description,boolean isLocked) {
        this.setName(name);
        this.setDescription(description);
        this.setLocked(isLocked);
        items.add(new Furniture("Выдвижной ящик", "Верхний ящик под столешницей",""));
        items.add(new Window("Окно", "Окно с ручкой у раковины","Окно открыто, но оно слишком маленькое, чтобы выбраться"));
    }
}
