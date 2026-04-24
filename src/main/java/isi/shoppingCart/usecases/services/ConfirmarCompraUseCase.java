package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.Purchase;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.PurchaseRepository;

public class ConfirmarCompraUseCase {
    private PurchaseRepository purchaseRepository;
    private CartRepository cartRepository;

    public ConfirmarCompraUseCase(PurchaseRepository purchaseRepository, CartRepository cartRepository) {
        this.purchaseRepository = purchaseRepository;
        this.cartRepository = cartRepository;
    }

    public String execute() {
        Cart cart = cartRepository.getCart();

        if (cart == null) {
            return "Carrito No encontrado.";
        }

        Purchase purchase = new Purchase();
        purchase.AddCart(cart);
        purchase.SetActive();
        purchaseRepository.save(purchase);

        cartRepository.getCart().cleanCart();

        return "";
    }
}
