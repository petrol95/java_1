import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Java. Level 1. Lesson 7. Homework 7
 *
 * @author Olga Petrova
 * @version dated Jul 21, 2019
 */

class HomeWork7 extends JFrame {
    
    final String WINDOW_TITLE = "Feed Cats";
    final String BUTTON_ADD_FOOD = "Add Food";
    final String BUTTON_FEED_CATS = "Feed Cats";
    final int WINDOW_WIDTH = 450;
    final int WINDOW_HEIGHT = 300;
    
    Cat[] cats = {new Cat("Barsik", 10), new Cat("Murzik", 5), new Cat("Poushok", 15)};
    boolean[] fullness = {false, false, false}; // array for redrawing;
    Panel panel;
    Plate plate;
    JLabel plateLabel;
    
    public static void main(String[] args) {
        new HomeWork7();
    }
    
    HomeWork7() {
        setTitle(WINDOW_TITLE); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        
        panel = new Panel();
        plate = new Plate(0);
        JTextField field = new JTextField("25", 2);
        plateLabel = new JLabel("Food: 0");
        
        JButton buttonAdd = new JButton(BUTTON_ADD_FOOD);
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    plate.increaseFood(Integer.parseInt(field.getText()));
                } catch (NumberFormatException ex) {
                    System.err.println("Wrong format!");
                }
            System.out.println(plate);
            updateFood(plate.getFood());
            panel.repaint();
            }
        });
        JButton buttonFeed = new JButton(BUTTON_FEED_CATS);
        buttonFeed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < cats.length; i++) {
                    cats[i].eat(plate);
                    fullness[i] = cats[i].getFullness();
                    System.out.println(cats[i]);
                }
            System.out.println(plate);
            updateFood(plate.getFood());
            panel.repaint();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(field);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonFeed);
        
        JPanel labelPanel = new JPanel(); 
        add(labelPanel, BorderLayout.NORTH);
        labelPanel.add(plateLabel);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    // Update label Food
    void updateFood(int num) {
        if (num >= 0) {
            plateLabel.setText("Food: " + num);
            if (num == 0)
                plateLabel.setText("Please add food");
        }
    }
    
    class Panel extends JPanel { // for drawing
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < 3; i++) {
                g.setColor(new Color(255 - 100 * i, 127, 127));
                // Whiskers and tails
                g.drawLine(40 + 120 * i, 90, 90 + 120 * i, 95);
                g.drawLine(40 + 120 * i, 95, 90 + 120 * i, 90);
                g.drawLine(140 + 120 * i, 60, 140 + 120 * i, 130);
                // Hungry or fed 
                if (fullness[i]) {
                    g.fillOval(50 + 120 * i, 80, 30, 30);
                    g.fillOval(60 + 120 * i, 100, 80, 50);
                } else {
                    g.drawOval(50 + 120 * i, 80, 30, 30);
                    g.drawOval(60 + 120 * i, 100, 80, 50);
                    g.drawLine(140 + 120 * i, 60, 140 + 120 * i, 130);
                }
            }
        }
    }
}   

// class Cat
class Cat {
    private String name;
    private int appetite;
    boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    boolean getFullness() {
        return this.fullness;
    }

    void eat(Plate plate) {
        if (plate.getFood() >= this.appetite) {
            plate.dicreaseFood(appetite);
            this.fullness = true;
        } else
            this.fullness = false;
    }

    @Override
    public String toString() {
        return name + ": " + fullness;
    }
}

// class Plate
class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }
    
    int getFood() {
        return this.food;
    }

    void dicreaseFood(int food) {
        if (this.food >= food)
            this.food -= food;
    }

    void increaseFood(int food) {
        this.food += food;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}