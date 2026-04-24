package isi.shoppingCart.entities;

public class Purchase {
    private Cart cart;
    private boolean active;

    public Purchase(){
        cart = new Cart();
    }
    public void AddCart(Cart cart){this.cart =cart;}
    public void SetActive(){this.active =true;}
    //public Cart getCart() {return cart;}
    public boolean getActive(){
        return active;
    }
}
