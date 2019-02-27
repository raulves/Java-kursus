package ee.taltech.iti0202.tk2.art;

public class Painting {

    private String title;
    private String author;

    public Painting(String title, String author) {

        this.title = title;
        this.author = author;
    }

    public Painting(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if (author.isEmpty()) {
            return "This is a painting named " + title + " and made by an unknown artist.";
        }
        return "This is a painting named " + title + " and made by" + author + ".";
    }
}
