package notifications;

public class NotificationService implements Observer {
    @Override
    public void update(String event, String message) {
        System.out.println("[NOTIFICATION] " + event + ": " + message);
    }
}

