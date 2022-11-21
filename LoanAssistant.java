package LoanAssistant;

import javax.swing.*;
//import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.text.*;


class GUI{
    //gui component to be used
    JFrame f;
    JLabel balanceLabel,interestLabel,monthsLabel,paymentLabel,analysisLabel;
    JTextField balancetf,interesttf,monthstf,paymentf;
    JButton computeButton,newLoanButton,monthsButton,paymentButton,exitButton;
    JTextArea analysisTextArea;
    
    //var
    boolean computePayment;
    Color lightyellow = new Color(255,255,128);

    void show()
    {
        f = new JFrame("LOAN ASSISTENT");
        Font myfont = new Font("Arial",Font.PLAIN,16);
        
        //setting up the frame 
        f.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        f.pack();
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        f.setBounds((int) (0.5 * (screenSize.width - f.getWidth())), (int) (0.5 * (screenSize.height - f.getHeight())), f.getWidth(), f.getHeight());
        f.setVisible(true);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //balance 
        balanceLabel = new JLabel("Loan Balance");
        balanceLabel.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx =0;
        gridConstraints.gridy =0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10,10,0,0);
        f.getContentPane().add(balanceLabel,gridConstraints);

        balancetf = new JTextField();
        balancetf.setPreferredSize(new Dimension(100,25));
        balancetf.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx =1;
        gridConstraints.gridy =0;
        gridConstraints.insets = new Insets(10,10,0,10);
        f.getContentPane().add(balancetf,gridConstraints);


        //interest
        interestLabel = new JLabel();
        interestLabel.setText("Interest Rate");
        interestLabel.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        f.getContentPane().add(interestLabel, gridConstraints);

        interesttf = new JTextField();
        interesttf.setPreferredSize(new Dimension(100, 25));
        interesttf.setHorizontalAlignment(SwingConstants.RIGHT);
        interesttf.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        f.getContentPane().add(interesttf, gridConstraints);

        //months
        monthsLabel = new JLabel();
        monthsLabel.setText("Number of Payments");
        monthsLabel.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        f.getContentPane().add(monthsLabel, gridConstraints);

        monthstf = new JTextField();
        monthstf.setPreferredSize(new Dimension(100, 25));
        monthstf.setHorizontalAlignment(SwingConstants.RIGHT);
        monthstf.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        f.getContentPane().add(monthstf,gridConstraints);

        
        //payments
        paymentLabel = new JLabel();
        paymentLabel.setText("Monthly Payment");
        paymentLabel.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 0, 0);
        f.getContentPane().add(paymentLabel, gridConstraints);

        paymentf = new JTextField();
        paymentf.setPreferredSize(new Dimension(100, 25));
        paymentf.setHorizontalAlignment(SwingConstants.RIGHT);
        paymentf.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 10, 0, 10);
        f.getContentPane().add(paymentf, gridConstraints);
        
        //end of step2
        //buttons
        computeButton = new JButton();
        newLoanButton = new JButton();
        //pg12
        //9nov
        computeButton.setText("Compute Monthly Payment");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        f.getContentPane().add(computeButton, gridConstraints);
        computeButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
            {
            computeButtonActionPerformed(e);
            }
        }); 
        
        newLoanButton.setText("new Loan analysis");
        newLoanButton.setEnabled(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.gridwidth = 2;
        gridConstraints.insets = new Insets(10, 0, 10, 0);
        f.getContentPane().add(newLoanButton, gridConstraints);

        newLoanButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
            {
                newLoanButtonActionPerformed(e);
            }
        });

        //months and payment button
        monthsButton = new JButton();
        monthsButton.setText("X");
        monthsButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        f.getContentPane().add(monthsButton, gridConstraints);
        monthsButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
            {
                monthsButtonActionPerformed(e);
            }
        });

        paymentButton = new JButton();
        paymentButton.setText("X");
        paymentButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 3;
        gridConstraints.insets = new Insets(10, 0, 0, 0);
        f.getContentPane().add(paymentButton,gridConstraints);
        paymentButton.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
            {
                paymentButtonActionPerformed(e);
            }
        });

        //analysis label and textarea and a exit button
        analysisLabel = new JLabel("Loan Analysis");
        analysisLabel.setFont(myfont);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 0;
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(0, 10, 0, 0);
        f.getContentPane().add(analysisLabel, gridConstraints);

        analysisTextArea = new JTextArea();
        analysisTextArea.setPreferredSize(new Dimension(250,150));
        analysisTextArea.setFocusable(false);
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTextArea.setFont(myfont);
        analysisTextArea.setEditable(false);
        analysisTextArea.setBackground(Color.WHITE);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 1;
        gridConstraints.gridheight = 4;
        gridConstraints.insets = new Insets(0, 10, 0, 10);
        f.getContentPane().add(analysisTextArea, gridConstraints);

        //exit
        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 5;
        f.getContentPane().add(exitButton, gridConstraints);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                exitButtonActionPerformed(e);
            }
        });
        


    }




    private void computeButtonActionPerformed(ActionEvent e)
    {
        double balance,interest,payment;
        int months;
        double monthlyInterest,multiplier;
        double loanBalance,finalPayment;

        balance = Double.valueOf(balancetf.getText()).doubleValue();
        interest = Double.valueOf(interesttf.getText()).doubleValue();
        monthlyInterest = interest/1200;

        //computing months payment
        if(computePayment)
        {
        months = Integer.valueOf(monthstf.getText()).intValue();
        multiplier = Math.pow(1+monthlyInterest,months);
        payment = balance * monthlyInterest * multiplier/(multiplier-1);
        paymentf.setText(new DecimalFormat("0.00").format(payment));
        }
        else
        {
            //computing no of payments
            payment = Double .valueOf(paymentf.getText()).doubleValue();
            months = (int)((Math.log(payment)-Math.log(payment-balance*monthlyInterest))/Math.log(1+monthlyInterest));
            monthstf.setText(String.valueOf(months));
        }

        //analysis text area
        //reset payment prior to analysis to fix at 2 decimals
        payment = Double.valueOf(paymentf.getText()).doubleValue();
        analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
        analysisTextArea.append("\n"+ "Interest Rate: "+new DecimalFormat("0.00").format(interest)+"%");
        
        //process all but last payment
        loanBalance = balance;
        for(int paymentNumber =1;paymentNumber<=months-1;paymentNumber++)
        {
            loanBalance +=loanBalance*monthlyInterest-payment;
        }

        //final payment
        finalPayment = loanBalance;
        if(finalPayment>payment)
        {
            //apply one more payment
            loanBalance+=loanBalance*monthlyInterest-payment;
            finalPayment = loanBalance;
            months++;
            monthstf.setText(String.valueOf(months));
        }

        analysisTextArea.append("\n\n"+String.valueOf(months-1)+"Payments of $"+new DecimalFormat("0.00").format(payment));
        analysisTextArea.append("\n"+"Final Payment of: $" +new DecimalFormat("0.00").format(finalPayment));
        analysisTextArea.append("\n"+"Total Payment of $" +new DecimalFormat("0.00").format((months-1)*payment +finalPayment));
        analysisTextArea.append("\n"+"Interest Paid $" + new DecimalFormat("0.00").format((months-1)*payment +finalPayment -balance));
        computeButton.setEnabled(false);
        newLoanButton.setEnabled(true);
        newLoanButton.requestFocus();
    }

    private void newLoanButtonActionPerformed(ActionEvent e)
    {
        //clear computed value and analysis
        if(computePayment)
        {
            paymentf.setText("");
        }
        else
        {
            monthstf.setText("");
        }

        analysisTextArea.setText("");
        computeButton.setEnabled(true);
        newLoanButton.setEnabled(false);
        balancetf.requestFocus();
    }
    private void monthsButtonActionPerformed(ActionEvent e)
    {
        //will compute months
        computePayment = false;
        paymentButton.setVisible(true);
        monthsButton.setVisible(false);
        monthstf.setBackground(lightyellow);
        monthstf.setText("");
        monthstf.setEditable(false);
        monthstf.setFocusable(false);

        paymentf.setEditable(true);
        paymentf.setFocusable(true);
        paymentf.setBackground(Color.WHITE);
        computeButton.setText("Compute Number of Payments");
        balancetf.requestFocus();

    }
    private void paymentButtonActionPerformed(ActionEvent e)
    {
        // will compue payment 
        computePayment = true;
        paymentButton.setVisible(false);
        monthsButton.setVisible(true);
        monthstf.setEditable(true);
        monthstf.setBackground(Color.WHITE);
        monthstf.setFocusable(true);
        paymentf.setText("");
        paymentf.setEditable(false);
        paymentf.setFocusable(false);
        paymentf.setBackground(lightyellow);
        computeButton.setText("Compute Monthly Payment");
        balancetf.requestFocus();

    }
    private void exitButtonActionPerformed(ActionEvent e)
    {
        System.exit(0);
    }

}
public class LoanAssistant {
    public static void main(String[] args) {
        System.out.println("running");
        GUI g = new GUI();
        g.show();
        g.paymentButton.doClick();
    }    
}
