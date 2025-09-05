public class Kitchen extends Room {

    public Kitchen(String name, String description,boolean isLocked) {
        this.setName(name);
        this.setDescription(description);
        this.setLocked(isLocked);
        items.add(new Furniture("Выдвижной ящик", "Верхний ящик под столешницей", """
                На дне ящика нацарапано:
                
                bedroom1	bedroom2	bedroom3
                	|			|			|
                	o			l			l
                	|			|			|
                -------------------------------
                              lobby           --AC--> exit
                -------------------------------
                	|			|			|
                	o			l			o
                	|			|			|
                bathroom1	bathroom2	kitchen"""));
        items.add(new Window("Окно", "Окно с ручкой у раковины","Окно открыто, но оно слишком маленькое, чтобы выбраться"));
    }
}
