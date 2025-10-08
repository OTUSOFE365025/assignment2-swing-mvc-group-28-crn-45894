import java.text.NumberFormat;

// Controller
public class Product {
    // Attributes
	private String name;
	private double price;
	private int UPC;

    // Contructor
	Product (int code, String name, double price) {
		this.UPC = code;
		this.name = name;
		this.price = price;
	}

    // Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUPC() {
		return UPC;
	}

	public void setUPC(int UPC) {
		this.UPC = UPC;
	}

    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Product name: " + name + ", Price = " + formatter.format(price);
    }
}
