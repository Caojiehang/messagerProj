package Server;

/**
 * local server model
 */
public class LocalServer {
    public  static  void main(String[] args) {
        MasterServer masterServer = new MasterServer();
        masterServer.start();
    }
}

