package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.CartItem;
import isi.shoppingCart.entities.Product;
import isi.shoppingCart.entities.Purchase;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;
import isi.shoppingCart.usecases.ports.PurchaseRepository;

import java.util.List;

public class ShoppingCartApp {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private PurchaseRepository purchaseRepository;
    private AgregarProductoAlCarritoUseCase agregarProductoAlCarritoUseCase;
    private ConfirmarCompraUseCase confirmarCompraUseCase;

    public ShoppingCartApp(ProductRepository productRepository,
                           CartRepository cartRepository,
                           PurchaseRepository purchaseRepository,
                           ConfirmarCompraUseCase confirmarCompraUseCase,
                           AgregarProductoAlCarritoUseCase agregarProductoAlCarritoUseCase) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.purchaseRepository = purchaseRepository;
        this.agregarProductoAlCarritoUseCase = agregarProductoAlCarritoUseCase;
        this.confirmarCompraUseCase =confirmarCompraUseCase;
    }

    public List<Product> getCatalogProducts() {
        return productRepository.findAll();
    }

    public List<CartItem> getCartItems() {
        Cart cart = cartRepository.getCart();
        return cart.getItems();
    }

    public List<Purchase> getPurchases() {
        return purchaseRepository.getPurchases();
    }

    public List<Purchase> getPurchasesConfirmed(){
        return purchaseRepository.getPurchasesConfirmed();
    }

    public double getCartTotal() {
        Cart cart = cartRepository.getCart();
        return cart.getTotal();
    }

    public String addProductToCart(int productId) {
        return agregarProductoAlCarritoUseCase.execute(productId);
    }

    public String ConfirmarCompra(){
        return confirmarCompraUseCase.execute();
    }
}
