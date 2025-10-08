import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;

// Implement the Property Listener to connect the display to the other objects
public class Display implements PropertyChangeListener {
    // Instantiate product object and subtotal variable to be displayed
	private Product product;
    private double subtotal = 0;

    private ArrayList<String> listToView = new ArrayList<String>();
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private final ScrollableList viewport;

    // Constructor
	Display (ScrollableList viewport) {
        this.viewport = viewport;
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equalsIgnoreCase("Products List")) {
            // Get the updated product
            listToView = (ArrayList<String>) evt.getNewValue();
        }

        else if (evt.getPropertyName().equalsIgnoreCase("Subtotal")) {
            subtotal += (Double) evt.getNewValue();
            listToView.add("Subtotal: " + formatter.format(subtotal));
        }

        // Update the viewport
        viewport.update(listToView);
	}

}
