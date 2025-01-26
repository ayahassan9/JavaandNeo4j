new JLabel(resizedIcon);
        backgroundImage.setLayout(new GridBagLayout()); // Center alignment
        add(backgroundImage, BorderLayoupackage employe.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
    private JButton viewButton, addButton, updateButton, removeButton;
    // Constructor to initialize the GUI
    public Home() {
        // Set layout manager
        setLayout(new BorderLayout());
        // Heading label (Title at the top)
        JLabel headingLabel = new JLabel("Employee Management System", JLabel.CENTER);
        headingLabel.setFont(new Font("Raleway", Font.BOLD, 30));
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setOpaque(true); // To set background color
        headingLabel.setBackground(new Color(0, 0, 128)); // Navy background
        headingLabel.setPreferredSize(new Dimension(1120, 60)); // Adjust height
        add(headingLabel, BorderLayout.NORTH);
        // Background image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image scaledImage = icon.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel backgroundImage = t.CENTER);
        // GridBagConstraints for flexible alignment
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Buttons initialization
        addButton = new JButton("Add Employee");
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundImage.add(addButton, gbc);
        addButton.addActionListener(this);
        viewButton = new JButton("View Employees");
        gbc.gridx = 1;
        gbc.gridy = 0;
        backgroundImage.add(viewButton, gbc);
        viewButton.addActionListener(this);
        updateButton = new JButton("Update Employee");
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundImage.add(updateButton, gbc);
        updateButton.addActionListener(this);
        removeButton = new JButton("Remove Employee");
        gbc.gridx = 1;
        gbc.gridy = 1;
        backgroundImage.add(removeButton, gbc);
        removeButton.addActionListener(this);
        // Frame properties
        setTitle("Employee Management System - Home");
        setSize(1120, 630);
        setLocationRelativeTo(null); // Center window on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    // Event handling for button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == addButton) {
            setVisible(false);
            new AddEmployee();
        } else if (source == viewButton) {
            setVisible(false);
            new ViewEmployee();
        } else if (source == updateButton) {
            setVisible(false);
            new ViewEmployee(); // Consider updating this to a dedicated UpdateEmployee window
        } else if (source == removeButton) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    // Main method to launch the application
    public static void main(String[] args) {
        new Home();
    }
}
