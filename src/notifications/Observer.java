package notifications;

public interface Observer {
    void update(String event, String message);
}

