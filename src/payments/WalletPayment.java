package payments;

import java.util.Random;

public class WalletPayment implements PaymentStrategy {
    private String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean pay(double amount) {
        Random random = new Random();
        return random.nextBoolean();
    }
}

