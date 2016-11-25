package Store;
/*
 * the abstract class storeItem. has an int value for the cost of the object and a string for the items name.
 * Also returns strings and int so i can print them.
 */
public abstract class storeItem {
	private int cost;
	private String item;
	
	public storeItem(int cost, String item){
		this.cost=cost;
		this.item=item;
	}
	public int toInt(){
		return cost;
	}
	public String toString(){
		return item;
	}
	public String costToString(){
		return String.valueOf(cost);
	}

}
