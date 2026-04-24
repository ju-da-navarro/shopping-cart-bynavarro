package isi.shoppingCart.usecases.ports;
import java.util.List;
import isi.shoppingCart.entities.Purchase;

public interface PurchaseRepository {
    void save(Purchase purchase);
    List<Purchase> getPurchases();
    List<Purchase> getPurchasesConfirmed();

}

