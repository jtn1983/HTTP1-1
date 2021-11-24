import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    private final int connections;
    private final List<String> validPaths;

    public Server(int port, int connections, List<String> validPaths) {
        this.port = port;
        this.connections = connections;
        this.validPaths = validPaths;
    }

    public void startServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(connections);
        try (final ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final var socket = serverSocket.accept();
                Connection connection = new Connection(socket, validPaths);
                executorService.execute(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
