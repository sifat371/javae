import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
   A GUI for the Bank Simulator. 
*/
public class BankSimulatorFrame extends JFrame
{
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 200;

   private BankData data;
   private int currentPosition;
   private BankAccount currentAccount;
   private JButton addButton;
   private JButton findButton;
   private JButton depositButton;
   private JLabel balanceLabel;

   public BankSimulatorFrame()
   {
      data = new BankData();
      setLayout(new GridLayout(0, 1));
      add(createLoadPanel());
      add(createFindPanel());
      add(createBalancePanel());
      add(createDepositPanel());
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private JPanel createLoadPanel()
   {
      JPanel panel = new JPanel();
      JButton loadButton = new JButton("Load");
      panel.add(loadButton);

      class LoadButtonListener implements ActionListener
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            JFileChooser chooser = new JFileChooser();
            int r = chooser.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION)
            {
               try
               {
                  data.open(chooser.getSelectedFile().getPath());
                  findButton.setEnabled(true);
                  addButton.setEnabled(true);
               } catch (IOException ex)
               {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
               }
            }
         }
      }

      loadButton.addActionListener(new LoadButtonListener());

      return panel;
   }

   private JPanel createFindPanel()
   {
      JPanel panel = new JPanel();
      findButton = new JButton("Find");
      findButton.setEnabled(false);
      panel.add(findButton);
      addButton = new JButton("Add");
      addButton.setEnabled(false);
      panel.add(addButton);

      panel.add(new JLabel("Account number: "));
      final JTextField accountText = new JTextField(10);
      panel.add(accountText);

      class FindButtonListener implements ActionListener
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            try
            {
               int accountNumber = Integer.parseInt(accountText.getText());
               currentPosition = data.find(accountNumber);
               if (currentPosition < 0)
               {
                  JOptionPane.showMessageDialog(null, "account not found");
                  depositButton.setEnabled(false);
               }
               else
               {
                  currentAccount = data.read(currentPosition);
                  balanceLabel.setText("" + currentAccount.getBalance());
                  depositButton.setEnabled(true);
               }
            } catch (IOException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
               depositButton.setEnabled(false);
            } catch (NumberFormatException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
               depositButton.setEnabled(false);
            }
         }
      }

      findButton.addActionListener(new FindButtonListener());

      class AddButtonListener implements ActionListener
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            try
            {
               int accountNumber = Integer.parseInt(accountText.getText());
               currentPosition = data.find(accountNumber);
               if (currentPosition < 0)
               {
                  currentPosition = data.size();
                  currentAccount = new BankAccount(accountNumber, 0);
                  data.write(currentPosition, currentAccount);
               }
               else
               {
                  JOptionPane.showMessageDialog(null, "account already exists");
                  currentAccount = data.read(currentPosition);

               }
               balanceLabel.setText("" + currentAccount.getBalance());
               depositButton.setEnabled(true);
            } catch (IOException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
               depositButton.setEnabled(false);
            } catch (NumberFormatException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
               depositButton.setEnabled(false);
            }
         }
      }

      addButton.addActionListener(new AddButtonListener());

      return panel;
   }

   private JPanel createBalancePanel()
   {
      JPanel panel = new JPanel();
      balanceLabel = new JLabel("                 ");
      panel.add(new JLabel("Balance: "));
      panel.add(balanceLabel);
      return panel;
   }

   private JPanel createDepositPanel()
   {
      JPanel panel = new JPanel();
      depositButton = new JButton("Deposit");
      panel.add(depositButton);
      panel.add(new JLabel("Amount: "));
      final JTextField amountText = new JTextField(10);
      panel.add(amountText);

      depositButton.setEnabled(false);

      class DepositButtonListener implements ActionListener
      {
         @Override
         public void actionPerformed(ActionEvent event)
         {
            try
            {
               double amount = Double.parseDouble(amountText.getText());
               currentAccount.deposit(amount);
               data.write(currentPosition, currentAccount);
               balanceLabel.setText("" + currentAccount.getBalance());
               depositButton.setEnabled(true);
            } catch (IOException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (NumberFormatException ex)
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
         }
      }

      depositButton.addActionListener(new DepositButtonListener());

      return panel;
   }
}
