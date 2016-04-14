public class TicTacToeAI
{
   public TicTacToeAI()
   {
   }
   
   public int getNextMove(String currentState[], int turn)
   {
      int move = -1;
      if (turn == 0)
      {
         move = getFirstTurn();
      }
      if (turn == 1)
      {
         move = getSecondTurn(currentState[]);
      }
      if (turn == 2)
      {
         move = getThirdTurn(currentState[]);
      }
      if (turn == 3)
      {
         move = getFouthTurn(currentState[]);
      }
      if (turn == 4)
      {
         move = getFifthTurn(currentState[]);
      }
      if (turn == 5)
      {
         move = getSixthTurn(currentState[]);
      }
      if (turn == 6)
      {
         move = getSeventhTurn(currentState[]);
      }
      if (turn == 7)
      {
         move = getEigthTurn(currentState[]);
      }
      if (turn == 8)
      {
         move = getLastTurn(currentState[]);
      }
      return move;
   }
   
   public int getFirstTurn()
   {
      int place = -1;
      //First turn if X
      
      //Calculate move
      place = 0;
      
      
      return place;
   }
   
   public int getSecondTurn(String currentState[])
   {
      int place = -1;
      //First turn if O
      
      //Calculate move
      if (currentState[4] != null)
      {
         place = 0;
      }
      else
      {
         place = 4;
      }
      
      
      return place;
   }

   public int getThirdTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      if (currentState[3] != null || currentState[4] != null || currentState[6] != null)
      {
         if currentState[1] == null;
         return 1;
      }
      
      return place;
   }
   
   public int getFourthTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      
      return place;
   }
   
   public int getFifthTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      
      return place;
   }
   
   public int getSixthTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      
      return place;
   }
   
   public int getSeventhTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      
      return place;
   }
   
   public int getEigthTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      
      return place;
   }
   
   public int getLastTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      for (int i=0; i < 9; i++)
      {
         if (currentState[i] != null)
         {
            place = i + 1;
            break;
         }
      }
           
      return place;
   }
}
