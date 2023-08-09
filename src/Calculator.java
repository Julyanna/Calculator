import javax.lang.model.type.ErrorType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Calculator extends JFrame{

    public static void main(String[] args){
        // Создание окна
        JFrame frame = new JFrame("GridBagLayoutTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Определить панель содержания
        createPanelUI(frame.getContentPane());
        // Показать окно
        frame.pack();
        frame.setVisible(true);

        JPanel contents = new JPanel(new FlowLayout());



    }

    /**
     * Процедура добавления кнопки в контейнер
     * @param caption заголовок кнопки
     * @param container контейнер
     */
    public static void create_JLabel(GridBagConstraints constraints, Container container, String name, int gridx){
        JLabel label = new JLabel(name);
        change_constraints(constraints, gridx);
        container.add(label, constraints);
    }
    public static void change_constraints(GridBagConstraints constraints, int gridx){
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 1;
        constraints.gridx = gridx;
    }
    public static void createPanelUI(Container container) {
        JButton button;
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // По умолчанию -- натуральная высота, максимальная ширина
        constraints.weightx = 0.5;
        constraints.gridy = 0 ; // нулевая ячейка таблицы по вертикали
        create_JLabel(constraints, container,"Первое число", 0 );// нулевая ячейка таблицы по горизонтали
        create_JLabel(constraints, container,"Второе число", 1 );// первая ячейка таблицы по горизонтали

        constraints.gridy = 1 ; // первая ячейка таблицы по вертикали

        JTextField field1 = new JTextField(10);
        change_constraints(constraints, 0);  // нулевая ячейка таблицы по горизонтали
        container.add(field1, constraints);

        JTextField field2 = new JTextField(10);
        change_constraints(constraints, 1); // первая ячейка таблицы по горизонтали
        container.add(field2, constraints);


        constraints.gridy = 2 ; // вторая ячейка таблицы по вертикали

        button = new JButton("+");
        change_constraints(constraints, 0); // нулевая ячейка таблицы по горизонтали
        container.add(button, constraints);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer number1 = Integer.parseInt(field1.getText());
                    Integer number2 = Integer.parseInt(field2.getText());
                    Integer result = number1 + number2;
                    JOptionPane.showInputDialog("Результат = ", result);
                } catch (NumberFormatException me) {
                    JOptionPane.showInputDialog("Введите две цифры!");
                    return;
                }
            }
            }
        );

        button = new JButton("-");
        change_constraints(constraints, 1);
        container.add(button, constraints);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer number1 = Integer.parseInt(field1.getText());
                    Integer number2 = Integer.parseInt(field2.getText());
                    Integer result = number1 - number2;
                    JOptionPane.showInputDialog("Результат = ", result);
                } catch (NumberFormatException me) {
                    JOptionPane.showInputDialog("Введите две цифры!");
                    return;
                }
            }
        }
        );

        constraints.gridy = 3 ; // третья ячейка таблицы по вертикали

        button = new JButton("/");
        change_constraints(constraints, 0);
        container.add(button, constraints);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Double number1 = Double.parseDouble(field1.getText());
                    Double number2 = Double.parseDouble(field2.getText());
                    if (number2 == 0) {
                        JOptionPane.showInputDialog("Невозможно деление на ноль!");
                    } else {
                        Double result = number1 / number2;
                        JOptionPane.showInputDialog("Результат = ", result);
                    }
                } catch (NumberFormatException me) {
                    JOptionPane.showInputDialog("Введите две цифры!");
                    return;
                }
            }
        }
        );

        constraints.gridy = 3 ; // третья ячейка таблицы по вертикали

        button = new JButton("*");
        change_constraints(constraints, 1);
        container.add(button, constraints);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer number1 = Integer.parseInt(field1.getText());
                    Integer number2 = Integer.parseInt(field2.getText());
                    Integer result = number1 * number2;
                    JOptionPane.showInputDialog("Результат = ", result);
                } catch (NumberFormatException me) {
                    JOptionPane.showInputDialog("Введите две цифры!");
                    return;
                }
            }
        }
        );

        constraints.gridy = 4 ; // четвертая ячейка таблицы по вертикали

        button = new JButton("С");
        change_constraints(constraints, 0);
        container.add(button, constraints);
        button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 field1.setText("");
                 field2.setText("");

             }
         }
        );


    }





}


