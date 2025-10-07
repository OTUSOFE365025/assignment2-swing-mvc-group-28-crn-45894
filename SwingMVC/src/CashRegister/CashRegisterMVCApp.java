import java.util.ArrayList;

public class CashRegisterMVCApp {

	public static void main(String[] args) {
        // Setup register model
        CashRegisterModel register = new CashRegisterModel(new ArrayList<Product>());

        // Setup display view
        Display display = new Display();
        register.addPropertyChangeListener(display);

        // Setup keyboard controller
        Keyboard keyboard = new Keyboard("Keyboard", register);
	}
	
}
