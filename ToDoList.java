import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoList() {
        // Create frame
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Input field and buttons
        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Selected");

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Top panel for input and add
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(taskInput, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        // Bottom panel for delete button
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);

        // Add components to main panel
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Button actions
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        // Run the UI in the Event Dispatch Thread
        SwingUtilities.invokeLater(ToDoList::new);
    }
}
