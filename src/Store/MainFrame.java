package Store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel NrItemsCart, TotalCartCost, LastItemToCart;
	private JButton FlashLight, Bicycle, Bag, ClearCart;
	private JPanel ButtonPanel, CartSizePanel, TotalCartCostPanel, LastItemPanel, NorthPanel, SouthPanel;
	private JTextArea ItemsInCartArea;
	private Cart cart = new Cart();
	BorderLayout NorthLayout = new BorderLayout(); // layout for north panel
	BorderLayout SouthLayout = new BorderLayout(); // layout for south panel
	
	
	public MainFrame (){
		
		//makes all buttons
		ButtonPanel = new JPanel();
		FlashLight = new JButton("Buy FlashLight");
		Bicycle = new JButton("Buy Bicycle");
		Bag = new JButton("Buy Bag");
		ClearCart = new JButton("ClearCart");
		
		//action listeners for all buttoms. adds Bag to Cart and sets labels
		Bag.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cart.addStoreItem(new Bag());
				cart.increaseCartPrice();
				setLabels();
			}
		});
		//clear Cart, sets totalPrice to 0 and sets all labels
		ClearCart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cart.ClearCart();
				try{	// try to set labels. if arrayindex of last item to cart outof bounds. catch "no items in cart"
					setLabels();
				} catch (ArrayIndexOutOfBoundsException e1 ){
					LastItemToCart.setText("No items in cart");
					ItemsInCartArea.setText("");
				}
			}
		});
		//action listeners for all buttoms. adds FlashLight to Cart and sets labels
		FlashLight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cart.addStoreItem(new Flashlight());
				cart.increaseCartPrice();
				setLabels();
			}
		});
		//action listeners for all buttoms. adds Bicycle to Cart and sets labels
		Bicycle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cart.addStoreItem(new Bicycle());
				cart.increaseCartPrice();
				setLabels();
			}
		});
		
		// Adds all buttons to buttonPanel
		ButtonPanel.add(Bicycle, BorderLayout.NORTH);
		ButtonPanel.add(FlashLight, BorderLayout.NORTH);
		ButtonPanel.add(Bag, BorderLayout.NORTH);
		ButtonPanel.add(ClearCart, BorderLayout.NORTH);
		
		//makes panel for items in cart. labels shows how many items are in cart
		CartSizePanel = new JPanel();
		NrItemsCart = new JLabel("Number of items in cart is" + cart.CartSize());
		CartSizePanel.setBackground(Color.GREEN);
		CartSizePanel.add(NrItemsCart, BorderLayout.CENTER);
	
		//The northpanel in the window, with buttons and cartsize
		NorthPanel = new JPanel();
		NorthPanel.setLayout(NorthLayout);
		NorthPanel.add(ButtonPanel, NorthLayout.NORTH);
		NorthPanel.add(CartSizePanel, NorthLayout.SOUTH);
		
		//the text area where you can see all objects in Cart. this is in the center of the window
		ItemsInCartArea = new JTextArea();
		ItemsInCartArea.setBackground(Color.WHITE);
		ItemsInCartArea.setLineWrap( true ); //breaks line when out of bounds from window
		ItemsInCartArea.setWrapStyleWord( true );
		
		// jpanel with the jlabel that shows totalprice of Cart:
		TotalCartCostPanel = new JPanel();
		TotalCartCost= new JLabel("Total price of cart is "+ cart.CartPriceToString() + "kr");
		TotalCartCostPanel.setBackground(Color.GREEN);
		TotalCartCostPanel.add(TotalCartCost, BorderLayout.WEST);
		
		// jpanel with the jlabel that prints the latest item to cart. and prints if cart is empty
		LastItemPanel = new JPanel();
		LastItemToCart = new JLabel("The cart is empty");
		LastItemPanel.add(LastItemToCart, BorderLayout.CENTER);
		
		//the south panel of the window. that shows totalprice of the cart and the latest item to cart.
		SouthPanel = new JPanel();
		SouthPanel.setLayout(SouthLayout);
		SouthPanel.add(TotalCartCostPanel, SouthLayout.NORTH);
		SouthPanel.add(LastItemPanel, SouthLayout.SOUTH);
		
		// sets title of the window, size of the window. and adds the north, south and center panels(textarea for center)
		this.setTitle("Simple Shop");
		this.add(NorthPanel, BorderLayout.NORTH);
		this.add(ItemsInCartArea, BorderLayout.CENTER);
		this.add(SouthPanel, BorderLayout.SOUTH);
		this.setSize(600, 400);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	//Sets texts for all labels, and textarea
	public void setLabels(){
		NrItemsCart.setText("Number of items in cart is " + cart.CartSize());
		TotalCartCost.setText("Total price of cart is "+ cart.CartPriceToString() + "kr");
		LastItemToCart.setText(cart.lastItemIntoCart());
		ItemsInCartArea.setText(cart.printAllItemsCart());
	}

}
	
