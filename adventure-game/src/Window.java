public class Window extends Item
implements Useful {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public Window(String name, String description, String text) {
        super(name, description);
        setText(text);
    }

    @Override
    public void use() {
        System.out.println(text);
    }
}