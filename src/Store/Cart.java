package Store;

import java.util.Vector;

public class Cart implements CartHandler {
	private Vector<storeItem> Cart = new Vector<storeItem>();
	private int CartPrice;
	
	@Override	//adds a storeItem to Cart
	public void addStoreItem(storeItem storeitem){
		Cart.add(storeitem);
	}
	@Override // increaces Cartprice by latest obj to Cart
	public void increaseCartPrice(){
		CartPrice+=Cart.get(Cart.size()-1).toInt();
	}
	@Override	// returns cartprice to string
	public String CartPriceToString(){
		return String.valueOf(CartPrice);
	}
	@Override	// clears Cart of objects and sets CartPrice to 0
	public void ClearCart(){
		CartPrice = 0;
		Cart.clear();
	}
	@Override // returns Cartsize as a string;
	public String CartSize(){
		return String.valueOf(Cart.size());
	}
	@Override //returns Cart to string.
	public String printAllItemsCart(){
			return Cart.toString();
		
	}
	@Override // returns the last objc into Cart as string and matches up the text for jlabel last item to cart.
	public String lastItemIntoCart(){
		return Cart.get(Cart.size()-1).toString() + " with the cost of " + Cart.get(Cart.size()-1).costToString() + " is being added to cart";
	}
	
}
	
