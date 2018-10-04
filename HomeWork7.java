import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Java. Level 1. Lesson 7. Homework 7
 *
 * @author Olga Petrova
 * @version dated Oct 4, 2018
 */

public class HomeWork7 extends JFrame implements ActionListener {

    private JLabel plateLabel;
    private JButton addFood;
    private JButton feedCats;
    private JTextField field;
    private MyCanvas canv;
    private JPanel buttonsPanel;
    private JPanel labelPanel;
    private Cat[] cats = {new Cat("Barsik", 10), new Cat("Murzik", 5), new Cat("Poushok", 15)};
    private Plate plate = new Plate(0);
    private boolean[] fullness = {false, false, false}; // array for redrawing

    public HomeWork7() {

        setTitle("Feed Cats"); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLayout(new BorderLayout());
        
        // Canvas for drawing
        canv = new MyCanvas();
        canv.init(fullness);
        add(canv, BorderLayout.CENTER);
        
        // Button panel
        buttonsPanel = new JPanel();
        add(buttonsPanel, BorderLayout.SOUTH);
        
        field = new JTextField("25", 2);
        buttonsPanel.add(field);

        addFood = new JButton("Add Food");
        addFood.addActionListener(this);
        buttonsPanel.add(addFood);

        feedCats = new JButton("Feed Cats");
        feedCats.addActionListener(this);
        buttonsPanel.add(feedCats);
         
        // Label panel
        labelPanel = new JPanel();
        add(labelPanel, BorderLayout.NORTH);
        plateLabel = new JLabel("Food: 0");
        labelPanel.add(plateLabel);
        
        setVisible(true);
    }

    // Event handler
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == feedCats) {
            for (int i = 0; i < cats.length; i++) {
                cats[i].eat(plate);
                fullness[i] = cats[i].getFullness();
                System.out.println(cats[i]);
            }
            System.out.println(plate);
            updateFood(plate.getFood());
            // Redrawing
            canv.init(fullness);
            canv.update(getGraphics());
            canv.repaint();
        } else if (ae.getSource() == addFood) {
            try {
                plate.increaseFood(Integer.parseInt(field.getText()));
                } catch (NumberFormatException e) {
                    System.err.println("Wrong format!");
                }
            System.out.println(plate);
            updateFood(plate.getFood());
        } else {
            setVisible(false);
            return;
        }
    }

// Update label Food
    void updateFood(int num) {
        if (num >= 0) {
            plateLabel.setText("Food: " + num);
            if (num == 0)
                plateLabel.setText("Please add food");
        }
    }

    public static void main(String[] args) {
        HomeWork7 myWindow = new HomeWork7();
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

// Canvas for drawing
class MyCanvas extends Canvas {

    boolean[] fullness = new boolean[3];

    // Drawing initialization
    public void init(boolean[] fullness) {
        for (int i = 0; i < 3; i++) {
            this.fullness[i] = fullness[i];
        }
    }

    // Drawing cats
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
    };
}