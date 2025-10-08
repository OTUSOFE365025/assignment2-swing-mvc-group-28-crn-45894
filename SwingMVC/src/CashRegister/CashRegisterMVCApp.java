import java.util.ArrayList;

public class CashRegisterMVCApp {

	public static void main(String[] args) {
        // Setup register model
        CashRegisterModel register = new CashRegisterModel(new ArrayList<Product>());

        // Setup scrollable list controller
        ScrollableList s_list = new ScrollableList("Receipt", new ArrayList<String>()); // Empty arraylist is just for instantiation

        // Setup display view
        Display display = new Display(s_list);
        register.addPropertyChangeListener(display);

        // Setup keyboard controller
        Keyboard keyboard = new Keyboard("Keyboard", register);


	}

}
