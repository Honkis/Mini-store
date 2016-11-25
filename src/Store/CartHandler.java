package Store;
/*
 *  an interface for what i can do with Cart or other shopping helpers like shopping bag. or a shopping car. whatever you like.
 */
public interface CartHandler {
	
	void addStoreItem(storeItem storeitem);
	void increaseCartPrice();
	String CartPriceToString();
	void ClearCart();
	String CartSize();
	String printAllItemsCart();
	String lastItemIntoCart();

}
