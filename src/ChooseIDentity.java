import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooseIDentity extends JFrame{
    private JButton userButton;
    private JButton adminButton;
    private JPanel root;

    public ChooseIDentity(Main main) {
        add(root);
        setTitle("The Library");
        setSize(400, 150);
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setUserFirstPage(ChooseIDentity.this);
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setAdminFirstPage(ChooseIDentity.this);
            }
        });

    }
}
