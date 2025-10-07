import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

// Implement the Property Listener to connect the display to the other objects
public class Display implements PropertyChangeListener {
    // Instantiate product object and subtotal variable to be displayed
	private Product product;
    private double subtotal = 0;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    // Empty contructor
	Display () {}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("Product")) {
            // Get the updated product
            product = (Product) evt.getNewValue();

            // Print to console (to "display")
            System.out.print("Product name: " + product.getName() + ", Price = " + formatter.format(product.getPrice()));
        }

        else if (evt.getPropertyName().equalsIgnoreCase("Subtotal")) {
            subtotal += (Double) evt.getNewValue();
            System.out.println(" --> Subtotal: " + formatter.format(subtotal));
        }
	}

}
