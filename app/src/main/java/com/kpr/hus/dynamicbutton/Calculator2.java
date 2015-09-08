package com.kpr.hus.dynamicbutton;

/*import java.awt.color;
        import java.awt.Dimension;
        import java.awt.FlowLayout;
        import java.awt.Font;
        import java.awt.HeadlessException;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import static javax.swing.JFrame.EXIT_ON_CLOSE;
        import javax.swing.JLabel;
        import javax.swing.JPanel;
        import javax.swing.JTextField;
        import javax.swing.UIManager;*/

public class Calculator2  {

    /*private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, point, sub, sum, div,
            mul, equal, neg, ms, mr,pow,sqrt;
    private JLabel mems, h1, h3, h2,h4;
    private JTextField res, r1, r2, r3, r4, r5;
    private Double num1, num2, result, memory;
    private String op;
    private ActionListener numLis, opLis, hLis;

    public Calculator2() throws HeadlessException {
        super("Calculator");
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setSize(310, 460);
        setLocation(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        hand();
        add(resPan());
        add(numPan());
        add(opPan());

    }

    private JPanel resPan() {
        JPanel resPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resPan.setPreferredSize(new Dimension(300, 135));
        mems = new JLabel();
        mems.setPreferredSize(new Dimension(280, 20));
        resPan.add(mems);
        h1 = new JLabel();
        h1.setPreferredSize(new Dimension(190, 20));
        h1.setBackground(Color.RED);
        h1.setForeground(Color.BLUE);
        resPan.add(h1);
        h2 = new JLabel();
        h2.setPreferredSize(new Dimension(80, 20));
        h2.setBackground(Color.RED);
        h2.setForeground(Color.BLUE);
        resPan.add(h2);
        h3 = new JLabel();
        h3.setPreferredSize(new Dimension(280, 20));
        resPan.add(h3);
        r1 = new JTextField();
        r1.setPreferredSize(new Dimension(80, 25));
        r1.setBackground(Color.RED);
        r1.setForeground(Color.BLUE);
        resPan.add(r1);
        r2 = new JTextField();
        r2.setPreferredSize(new Dimension(15, 25));
        r2.setBackground(Color.YELLOW);
        r2.setForeground(Color.RED);
        resPan.add(r2);
        r3 = new JTextField();
        r3.setPreferredSize(new Dimension(80, 25));
        r3.setBackground(Color.GREEN);
        r3.setForeground(Color.BLUE);
        resPan.add(r3);
        h4 = new JLabel("=");
        h4.setPreferredSize(new Dimension(10, 20));
        h4.setForeground(Color.RED);
        resPan.add(h4);
        r5 = new JTextField();
        r5.setPreferredSize(new Dimension(80, 25));
        r5.setBackground(Color.CYAN);
        r5.setForeground(Color.RED);
        resPan.add(r5);
        res = new JTextField();
        res.setPreferredSize(new Dimension(280, 25));
        resPan.add(res);
        // setVisible(mems);
        setVisible(true);
        return resPan;

    }

    private JPanel numPan() {
        JPanel numPan = new JPanel(new FlowLayout(FlowLayout.LEADING));
        numPan.setPreferredSize(new Dimension(170, 250));
        Dimension d = new Dimension(50, 50);

        b7 = new JButton("7");
        b7.setPreferredSize(d);
        b7.addActionListener(numLis);
        b7.addActionListener(hLis);
        numPan.add(b7);

        b8 = new JButton("8");
        b8.setPreferredSize(d);
        b8.addActionListener(numLis);
        b8.addActionListener(hLis);
        numPan.add(b8);

        b9 = new JButton("9");
        b9.setPreferredSize(d);
        b9.addActionListener(numLis);
        b9.addActionListener(hLis);
        numPan.add(b9);

        b4 = new JButton("4");
        b4.setPreferredSize(d);
        b4.addActionListener(numLis);
        b4.addActionListener(hLis);
        numPan.add(b4);

        b5 = new JButton("5");
        b5.setPreferredSize(d);
        b5.addActionListener(numLis);
        b5.addActionListener(hLis);
        numPan.add(b5);

        b6 = new JButton("6");
        b6.setPreferredSize(d);
        b6.addActionListener(numLis);
        b6.addActionListener(hLis);
        numPan.add(b6);

        b1 = new JButton("1");
        b1.setPreferredSize(d);
        b1.addActionListener(numLis);
        b1.addActionListener(hLis);
        numPan.add(b1);

        b2 = new JButton("2");
        b2.setPreferredSize(d);
        b2.addActionListener(numLis);
        b2.addActionListener(hLis);
        numPan.add(b2);

        b3 = new JButton("3");
        b3.setPreferredSize(d);
        b3.addActionListener(numLis);
        b3.addActionListener(hLis);
        numPan.add(b3);

        b0 = new JButton("0");
        b0.setPreferredSize(new Dimension(105, 50));
        b0.addActionListener(numLis);
        b0.addActionListener(hLis);
        numPan.add(b0);

        point = new JButton(".");
        point.setPreferredSize(d);
        point.addActionListener(numLis);
        numPan.add(point);

        return numPan;
    }

    private JPanel opPan() {
        JPanel opPan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        opPan.setPreferredSize(new Dimension(110, 300));
        Dimension d = new Dimension(50, 50);
        Font font = new Font("arial", Font.BOLD, 10);

        ms = new JButton("MS");
        ms.setPreferredSize(d);
        ms.setFont(font);
        ms.addActionListener(opLis);
        opPan.add(ms);

        mr = new JButton("MR");
        mr.setPreferredSize(d);
        mr.setFont(font);
        mr.addActionListener(opLis);
        opPan.add(mr);

        div = new JButton("/");
        div.setPreferredSize(d);
        div.addActionListener(opLis);
        div.addActionListener(hLis);
        opPan.add(div);

        mul = new JButton("*");
        mul.setPreferredSize(d);
        mul.addActionListener(opLis);
        mul.addActionListener(hLis);
        opPan.add(mul);

        sum = new JButton("+");
        sum.setPreferredSize(d);
        sum.addActionListener(opLis);
        sum.addActionListener(hLis);
        opPan.add(sum);

        sub = new JButton("-");
        sub.setPreferredSize(d);
        sub.addActionListener(opLis);
        sub.addActionListener(hLis);
        opPan.add(sub);

        neg = new JButton("-+");
        neg.setPreferredSize(d);
        neg.addActionListener(opLis);
        opPan.add(neg);


        equal = new JButton("=");
        equal.setPreferredSize(d);
        equal.addActionListener(opLis);
        equal.addActionListener(hLis);
        opPan.add(equal);

        pow = new JButton("^");
        pow.setPreferredSize(d);
        pow.addActionListener(opLis);
        pow.addActionListener(hLis);
        opPan.add(pow);

        sqrt = new JButton("s");
        sqrt.setPreferredSize(d);
        sqrt.addActionListener(opLis);
        sqrt.addActionListener(hLis);
        opPan.add(sqrt);


        return opPan;

    }

    private void hand() {

        numLis = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals(".")) {
                    res.setText(res.getText() + command);
                    return;
                }
                if (result != null) {
                    res.setText("");
                    result = null;
                }
                res.setText(res.getText() + command);

            }
        };
        opLis = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("MS")) {
                    memory =Double.valueOf(res.getText());
                    if (memory == 0) {
                        mems.setText("Memory is free");
                    } else {
                        mems.setText("Memory = " + memory.toString());
                    }
                    return;
                }
                if (command.equals("MR")) {
                    res.setText(memory.toString());
                    return;
                }
                if (command.equals("=")) {
                    num2 = Double.valueOf(res.getText());
                    r3.setText(num2.toString());
                    calculate();
                    res.setText(result.toString());
                    num1 = num2 = null;
                    op = null;
                    h2.setText(result.toString());
                    r5.setText(result.toString());
                    return;
                }


                if (command.equals("-+")) {
                    if (res.getText().startsWith("-")) {
                        res.setText(res.getText().substring(1));
                    } else {
                        res.setText("-" + res.getText());
                    }
                    return;
                }
                r2.setText(command.toString());
                num1 = Double.valueOf(res.getText());
                res.setText("");
                op = command;
                r1.setText(num1.toString());

            }

            private void calculate() {
                h1.setText(num1  + " " + op  + " " + num2 + " = ");
                if (op.endsWith("+")) {
                    result = num1 + num2;
                } else if (op.endsWith("-")) {
                    result = num1 - num2;
                } else if (op.endsWith("/")) {
                    result = num1 / num2;
                } else if (op.endsWith("*")) {
                    result = num1 * num2;
                } else if (op.endsWith("^")) {
                    result= Math.pow(num1, num2);
                } else if (op.equals("s")) {
                    result= Math.pow(num1,(1/num2));


                }
            }

        };
        hLis = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String a = null, b = null, c = null, d = null;
                String command = e.getActionCommand();
                String bb[] = {a, b, c, d};

                h3.setText(command);

            }
        };
    }
*/
}