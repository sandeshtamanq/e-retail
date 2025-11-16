package payments;

import java.util.Random;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        Random random = new Random();
        return random.nextBoolean();
    }
}

