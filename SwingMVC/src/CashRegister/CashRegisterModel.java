import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CashRegisterModel {

	private PropertyChangeSupport observables;
	private ArrayList<Product> myProducts;
	
	CashRegisterModel (ArrayList<Product> products) {
		myProducts = products;
		observables = new PropertyChangeSupport(this);
	}

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
		observables.addPropertyChangeListener(pcl);
    }
    
   
    public void processUPC(int code) {
        File inFile = new File("products.txt");
        Scanner scanner;
        boolean doesProductExist = false;
        Product foundProduct = null;

        try {
            scanner = new Scanner(inFile);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNext() && !doesProductExist) {
            String[] itemData = scanner.nextLine().split(" ");
            int itemUPC = Integer.parseInt(itemData[0]);
            String itemName = itemData[1];
            double itemPrice = Double.parseDouble(itemData[2]);

            if (code == itemUPC) {
                foundProduct = new Product(itemUPC, itemName, itemPrice);
                myProducts.add(foundProduct);
                doesProductExist = true;
            }
        }

        if (doesProductExist) {
            // Tell the display a product was found and send it to the display
            ArrayList<String> temp = new ArrayList<String>();

            for (Product p : myProducts) {
                temp.add(p.toString());
            }

            observables.firePropertyChange("Products List", null, temp);

            // Also send an update for the subtotal
            observables.firePropertyChange("Subtotal", null, foundProduct.getPrice());
        }

        else {
            System.out.println("== Product not found ==");
        }

    }

	public ArrayList<Product> getProductList() {
		return this.myProducts;
	}
}
