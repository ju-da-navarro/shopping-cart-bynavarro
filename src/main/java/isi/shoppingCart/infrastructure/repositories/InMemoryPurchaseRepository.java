package isi.shoppingCart.infrastructure.repositories;

import isi.shoppingCart.entities.Purchase;
import java.util.ArrayList;
import isi.shoppingCart.usecases.ports.PurchaseRepository;
import java.util.List;

public class InMemoryPurchaseRepository implements PurchaseRepository {

    private final List<Purchase> ListaCompras = new ArrayList<>();

    public void save(Purchase purchase) {
        ListaCompras.add(purchase);
    }

    public List<Purchase> getPurchases(){
        return ListaCompras;
    }

    public List<Purchase> getPurchasesConfirmed(){
        List<Purchase> ListaComprasConfirmadas = new ArrayList<>();
        for(Purchase purchase: ListaCompras){
            if(purchase.getActive()){
                ListaComprasConfirmadas.add(purchase);
            }
        }
        return ListaComprasConfirmadas;
    }
}