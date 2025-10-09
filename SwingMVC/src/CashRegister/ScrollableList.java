import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollableList {
    private ArrayList<String> list;
    private JList<String> displayList;
    private JScrollPane scrollPane = new JScrollPane();

    public ScrollableList(String title, ArrayList<String> list) {
        this.list = list;

        JPanel panel = new JPanel(new BorderLayout());
        displayList = new JList<String>(list.toArray(new String[list.size()]));

        scrollPane = new JScrollPane();
        displayList.setLayoutOrientation(JList.VERTICAL);

        panel.add(scrollPane);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(250, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void update(ArrayList<String> updatedList) {
        this.displayList = new JList<String>(updatedList.toArray(new String[updatedList.size()]));
        scrollPane.setViewportView(displayList);
    }
}