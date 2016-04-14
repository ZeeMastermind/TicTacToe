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
      if (currentState[1] != null || currentState[2] != null)
      {
         if (currentState[3] == null)
            place = 3;
      }
      
      if (currentState[3] != null || currentState[4] != null || currentState[6] != null)
      {
         if (currentState[1] == null)
            place = 1;
      }
      
      if (currentState[5] != null)
      {
         if (currentState[4] == null)
            place = 4;
      }
      
      if (place == -1 && currentState[2] == null)
         place = 2;
      
      return place;
   }
   
   public int getFourthTurn(String currentState[])
   {
      int place = -1;
      
      //Calculate move
      if (currentState[4] == "O")
      {
         //Conduct O middle operations
         
         
         //Grabs 0
         if ( (currentState[1] != null && currentState[2] != null) || (currentState[1] != null && currentState[5] != null) || (currentState[3] != null && currentState[6] != null) || (currentState[3] != null && currentState[5] != null) || (currentState[1] != null && currentState[7] != null) || (currentState[3] != null && currentState[7] != null))
         {
            if (currentState[0] == null)
               return 0;
         }
         
         //Grabs 1
         
         //Grabs 2
         
         //Grabs 3
         
         //Grabs 5
         
         //Grabs 6
         
         //Grabs 7
         
         //Grabs 8
      }
      else
      {
         //Conduct O as top-left corner operations
         if (currentState[1] != null)
         {
            if (currentState[7] == null)
               return 7;
         }
         
         if (currentState[2] != null)
         {
            if (currentState[6] == null)
               return 6;
         }
         
         if (currentState[3] != null)
         {
            if (currentState[5] != null)
               return 5;
         }
         
         if (currentState[5] != null)
         {
            if (currentState[3] != null)
               return 3;
         }
         
         if (currentState[6] != null || currentState[8] != null)
         {
            if (currentState[2] == null)
               return 2;
         }
         
         if (currentState[7] != null)
         {
            if (currentState[1] == null)
               return 1;
         }
      }
      
      
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
            place = i;
            break;
         }
      }
           
      return place;
   }
}
