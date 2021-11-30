import java.util.List;

public class Main {
    public static final int PORT = 9995;
    public static final int CONNECTION_COUNT = 64;
    public static final List<String> VALID_PATHS = List.of("/index.html", "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js", "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");

    public static void main(String[] args) {
        new Server(PORT, CONNECTION_COUNT, VALID_PATHS).startServer();
    }
}