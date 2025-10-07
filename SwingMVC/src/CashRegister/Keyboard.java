import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Keyboard {
    private JFrame frame;
    private JLabel UPCLabel;
    private JTextField UPCTextfield;
    private JButton UPCButton;
    private CashRegisterModel cashRegister;

    Keyboard(String title, CashRegisterModel register) {
        this.cashRegister = register;
	  
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Create UI elements
        UPCLabel = new JLabel("UPC:");
        UPCTextfield = new JTextField();
        UPCButton = new JButton("Enter");

        // Add UI elements to the frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCLabel))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCTextfield))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(UPCButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(UPCLabel)
                    .addComponent(UPCTextfield).addComponent(UPCButton)));

        frame.getContentPane().setLayout(layout);

        // Set the keyboard to manage the Enter button event and send the code to be processed
        this.UPCTextfield.addActionListener(e -> processUPCCode()); // Using the enter/return key
        this.UPCButton.addActionListener(e -> processUPCCode()); // Using the mouse to click the button
    }

    // Process the UPC code
    private void processUPCCode() {
        int code;

        try {
            code = Integer.parseInt(UPCTextfield.getText().strip());
            this.cashRegister.processUPC(code);
        }

        catch (NumberFormatException e) {
            System.out.println("== Invalid input ==");
        }
    }
}