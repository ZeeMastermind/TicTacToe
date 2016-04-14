/**
   * Constructs suitable window for Tic Tac Toe game
   * Checks for winstates in Tic Tac Toe game
   * @author Phillip Smith
   */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TicTacToe extends JFrame
{
   private JPanel top;
   private JPanel board;
   private JPanel bottom;
   private JPanel main;
   private JButton newGame;
   private JButton[] tiles;
   private String[] ticTacArray; 
   private JLabel winLose;
   private JLabel status;
   private String marker = "X";
   private int hWinState = 0;
   private int vWinState = 0;
   private int dWinState = 0;
   private int turn = 0;
   private int xWin = 0;
   private int oWin = 0;
   private int ties = 0;
   private boolean tieCheck = true;
   private boolean xCheck = false;
   private boolean oCheck = false;
   
   /**
      * Constructs the TicTacToe object
      * Constructs the frame
      * Calls upon the setComponents method
      */
   public TicTacToe()
   {
      this.setTitle("Tic-Tac-Toe");
      this.setSize(1000, 1000);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setComponents();
   }
   /**
      * Sets up button listener for the new game button
      * Sets all game values to default and begins game
      */
   public class startListener implements ActionListener
   {
      /**
         * Sets the grid of buttons to true
         * Clears the text of the grid of buttons
         * Clears the text of the score label (winLose)
         * Sets all needed values to default for a new game (win states, array, tie check)
         * Sets initial marker to X
         * Disables the New Game button
         */
      public void actionPerformed(ActionEvent start)
      {
         for(int i = 0; i < tiles.length; i++)
         {
            tiles[i].setEnabled(true);
            for(int r = 0; r < tiles.length; r++)
            {
               tiles[r].setText("");
               winLose.setText("");
               ticTacArray[r] = null;
               turn = 0;
               vWinState = 0;
               hWinState = 0;
               dWinState = 0;
               tieCheck = false;
               marker = "X";
            }
            newGame.setEnabled(false);
            status.setText("It is Team X's turn");
         }
      }
   }
   /**
      * Sets up button listener for the grid buttons
      * When a grid button is pressed, said buton is disabled and has text set to current marker
      * Calls upon winCheckers
      */
   public class buttonListener implements ActionListener
   {
      /**
         * Disables the button that the user presses
         * Keeps track of what turn it is (X is even, O is odd)
         * Sets the button text to the current marker
         * Sets the corresponding ticTacArray position to the current marker
         * Calls upon the winState methods to check for wins
         * If wins occur, prints appropriate winner, adds to said winners score, calls upon the printScore method, and enables the New Game button/disables any grid buttons still enabled
         */
      public void actionPerformed(ActionEvent press)
      {
         for(int j = 0; j < 9; j++)
         {
            if(press.getSource() == tiles[j])
            {
               tiles[j].setEnabled(false);
               
               if(turn%2 == 0)
               {
                  status.setText("It is Team O's turn");
               }
               else
               {
                  status.setText("It is Team X's turn");
               }
               if(turn%2 == 0)
               {
                  marker = "X";
               }
               else
               {
                  marker = "O";
               }
               tiles[j].setText(marker);
               ticTacArray[j] = marker;
               hWinCheck();
               vWinCheck();
               dWinCheck();
               if(hWinState == 1)
               {
                  for(int q = 0; q < tiles.length; q++)
                  {
                     tiles[q].setEnabled(false);
                  }
                  status.setText("Team " + marker + " wins!");
                  tieCheck = false;
                  if(marker.equals("X"))
                  {
                     xWin++;
                     printScore(xWin, oWin, ties);
                  }
                  else if(marker.equals("O"))
                  {
                     oWin++;
                     printScore(xWin, oWin, ties);
                  }
                  newGame.setEnabled(true);
                    
               }
               if(vWinState == 1)
               {
                  for(int s = 0; s < tiles.length; s++)
                  {
                     tiles[s].setEnabled(false);
                  }
                  status.setText("Team " + marker + " wins!");
                  tieCheck = false;
                  if(marker.equals("X"))
                  {
                     xWin++;
                     printScore(xWin, oWin, ties);
                  }
                  else if(marker.equals("O"))
                  {
                     oWin++;
                     printScore(xWin, oWin, ties);
                  }
                  newGame.setEnabled(true);
               }
               if(dWinState == 1)
               {
                  for(int t = 0; t < tiles.length; t++)
                  {
                     tiles[t].setEnabled(false);
                  }
                  status.setText("Team " + marker + " wins!");
                  tieCheck = false;
                  if(marker.equals("X"))
                  {
                     xWin++;
                     printScore(xWin, oWin, ties);
                  }
                  else if(marker.equals("O"))
                  {
                     oWin++;
                     printScore(xWin, oWin, ties);
                  }
                  newGame.setEnabled(true);

               }
               turn++;
               tie();
            }
            
         }      
      }
   }
   /**
      * Constructs the various components of the frame
      * Sets up the action listeners
      */
   private void setComponents()
   {
      top = new JPanel();
      board = new JPanel();
      bottom = new JPanel();
      main = new JPanel();
      newGame = new JButton();
      tiles = new JButton[9];
      ticTacArray = new String[9];
      winLose = new JLabel();
      status = new JLabel();
      startListener start = new startListener();
      buttonListener button = new buttonListener();
      
      main.setLayout(new BorderLayout());
      
      newGame.setText("New Game");
      newGame.addActionListener(start);
      top.add(newGame);
      main.add(top, BorderLayout.NORTH);
      
      
      board.setLayout(new GridLayout(3, 3));
      for(int i = 0; i < tiles.length; i++)
      {
         tiles[i] = new JButton();
         tiles[i].setEnabled(false);
         board.add(tiles[i]);
         tiles[i].addActionListener(button);
         tiles[i].setFont(new Font("Times New Roman", Font.BOLD, 350));                 
      }
      main.add(board, BorderLayout.CENTER); 

      status.setText("Press the New Game Button to begin.");
      bottom.add(status);
      bottom.add(winLose);
      main.add(bottom, BorderLayout.SOUTH);
      add(main);     
   }
   /**
      * Checks for horizontal wins
      * @return hWinState a value to check horizontal win states, 1 for a win and 0 for nothing
      */
   private int hWinCheck()
   {
      for(int hcheck1 = 0, hcheck2 = 1, hcheck3 = 2; hcheck3 < tiles.length; hcheck1 += 3, hcheck2 += 3, hcheck3 += 3)
      {
         if(ticTacArray[hcheck1] != null && ticTacArray[hcheck2] != null && ticTacArray[hcheck3] != null)
         {
            if(ticTacArray[hcheck1].equals(ticTacArray[hcheck2]) && ticTacArray[hcheck2].equals(ticTacArray[hcheck3]))
            {
               hWinState = 1;
               break;
            }
            else
            {
               hWinState = 0;
            }
         }
      }
      return hWinState;
   }
   /**
      * Checks for vertical wins
      * @return vWinState value used to check for vertical win states, 1 for a win and 0 for nothing
      */
   private int vWinCheck()
   {
      for(int vcheck1 = 0, vcheck2 = 3, vcheck3 = 6; vcheck3 < tiles.length; vcheck1++, vcheck2++, vcheck3++)
      {
         if(ticTacArray[vcheck1] != null && ticTacArray[vcheck2] != null && ticTacArray[vcheck3] != null)
         {
            if(ticTacArray[vcheck1].equals(ticTacArray[vcheck2]) && ticTacArray[vcheck2].equals(ticTacArray[vcheck3]))
            {
               vWinState = 1;
               break;
            }
            else
            {
               vWinState = 0;
            }
         }
      }
      return vWinState;
   }
   /**
      * Checks for diagonal wins
      * @return dWinState value used to check for vertical win states, 1 for a win and 0 for nothing
      */
   private int dWinCheck()
   {   
      for(int dcheck1 = 0, dcheck2 = 4, dcheck3 = 8; dcheck1 < 3; dcheck1 += 2, dcheck3 -= 2)
      {
         if(ticTacArray[dcheck1] != null && ticTacArray[dcheck2] != null && ticTacArray[dcheck3] != null)
         {
            if(ticTacArray[dcheck1].equals(ticTacArray[dcheck2]) && ticTacArray[dcheck2].equals(ticTacArray[dcheck3]))
            {
               dWinState = 1;
               break;
            }
            else
            {
               dWinState = 0;
            }
         }
      }
      return dWinState;
   }
   /**
      * Checks that all grid buttons have been pressed
      * If all buttons pressed, checks to see if a tie has occured
      * If tie occurs, prints Tie status and score, reenables New Game button
      * If no tie occurs, prints winner and current score
      */
   private void tie()
   { 
      for(int u = 0; u < tiles.length; u++)
      {
         if(tiles[u].isEnabled() == false)
         {
            tieCheck = true;
         }
         else
         {
            tieCheck = false;
            break;
         }
      }
      if(tieCheck == true)
      {
         hWinCheck();
         vWinCheck();
         dWinCheck();
         if(vWinState == 0 && hWinState == 0 && dWinState == 0)
         {
            status.setText("Tie");
            tieCheck = true;
            ties++;
            printScore(xWin, oWin, ties);
            newGame.setEnabled(true);
         }
         else
         {
            status.setText("Team " + marker + " wins!");
            
            printScore(xWin, oWin, ties);
         }
      }     
   }
   /**
      * Prints the current score
      * @param xC number of x wins
      * @param oC number of o wins
      * @param tC number of ties
      */
   private void printScore(int xC, int oC, int tC)
   {
      winLose.setText("X Wins: " + xC + "\n O Wins: " + oC + "\n Ties: " + tC);
   }
   /**
      * Sets the frame to visible
      */
   public void showMe()
   {
      this.setVisible(true);
   }
}
