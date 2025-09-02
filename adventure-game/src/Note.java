public class Note extends Item
implements Collectible, Useful {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Note(String name, String description,String text) {
        super(name, description);
        setText(text);
    }

    @Override
    public void use() {
        System.out.println("Текст из записки: \"" + text + "\".");
    }
}