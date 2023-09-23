package utils;

import models.Card;

public class CardHelper {
    public static void performDebit(final Card card, final double amount) {
        if (amount <= card.getBalance()) {
            card.setBalance(card.getBalance() - amount);
            return;
        }

        throw new IllegalStateException("Insufficient balance for debit");
    }

}