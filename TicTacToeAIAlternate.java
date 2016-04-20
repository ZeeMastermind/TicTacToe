public class TicTacToeAIAlternate
{   

   boolean firstSide3 = false; //Did enemy use a side prior to 3?
   boolean firstDiag3 = false; //Did enemy use a diagonal prior to 3?
   boolean firstLate5 = false; //Did enemy choose a no-win scenario prior to 5?
   boolean firstSide5 = false; //Did enemy choose a threatening side prior to 5?
   int select3 = -1; //Move used on turn 3
   int select5 = -1; //Move used on turn 5
   
   public TicTacToeAIAlternate()
   {
   }
   
   public int getNextMove(String currentState[], int turn)
   {
      int move = -1;
      if (turn == 0)
      {
         move = getFirstTurn(currentState);
      }
      if (turn == 1)
      {
         move = getSecondTurn(currentState);
      }
      if (turn == 2)
      {
         move = getThirdTurn(currentState);
      }
      if (turn == 3)
      {
         move = getFourthTurn(currentState);
      }
      if (turn == 4)
      {
         move = getFifthTurn(currentState);
      }
      if (turn == 5)
      {
         move = getSixthTurn(currentState);
      }
      if (turn == 6)
      {
         move = getSeventhTurn(currentState);
      }
      if (turn == 7)
      {
         move = getEigthTurn(currentState);
      }
      if (turn == 8)
      {
         move = getLastTurn(currentState);
      }
      return move;
   }
  
   private int getFirstTurn(String currentState[])
   {
      int select = -1;
      
      select = 4;
      
      return select;
   }
   
   private int getSecondTurn(String currentState[])
   {
      int select = -1;
      
      return select;
   }
   
   private int getThirdTurn(String currentState[])
   {
      int select = -1;
      
      if (currentState[1] != null || currentState[3] != null || currentState[5] != null || currentState[7] != null)
      {
         firstSide3 = true;
         
         if (currentState[1] != null)
            select = 0;
         if (currentState[3] != null)
            select = 6;
         if (currentState[5] != null)
            select = 2;   
         if (currentState[7] != null)
            select = 8;
         
      }
      if (currentState[0] != null || currentState[2] != null || currentState[6] != null || currentState[8] != null)
      {
         firstDiag3 = true;
         
         if (currentState[0] != null)
            select = 8;
         if (currentState[2] != null)
            select = 6;
         if (currentState[6] != null)
            select = 2;   
         if (currentState[8] != null)
            select = 0;
      }
      select3 = select;
      return select;
   }
   
   private int getFourthTurn(String currentState[])
   {
      int select = -1;
      
      return select;
      
   }
   
   private int getFifthTurn(String currentState[])
   {
      int select = -1;
      
      if (firstSide3)
      {
         if (select3 == 0)
         {
            if (currentState[8] == null)
            {
               select = 8; //win
            }
            else
            {
               select = 6;
            }
         }
         
         if (select3 == 2)
         {
            if (currentState[6] == null)
            {
               select = 6; //win
            }
            else
            {
               select = 0;
            }
         }
         
         if (select3 == 6)
         {
            if (currentState[2] == null)
            {
               select = 2; //win
            }
            else
            {
               select = 8;
            }
         }
         
         if (select3 == 8)
         {
            if (currentState[0] == null)
            {
               select = 0; //win
            }
            else
            {
               select = 2;
            }
         }
      }
      if (firstDiag3)
      {
         if (select3 == 8)
         {
            //diagonal chosen
            if (currentState[2] != null)
            {
               select = 1;
            }
            if (currentState[6] != null)
            {
               select = 3;
            }
            
            //Threat side chosen
            if (currentState[1] != null)
            {
               select = 2;
               firstSide5 = true;
            }
            
            if (currentState[3] != null)
            {
               select = 6;
               firstSide5 = true;
            }
            
            //Non-threat side chosen            
            if (currentState[5] != null)
            {
               select = 6;
               firstLate5 = true;
            }
            
            if (currentState[7] != null)
            {
               select = 2;
               firstLate5 = true;
            }
         }
         
         if (select3 == 6)
         {
            //diagonal chosen
            if (currentState[0] != null)
            {
               select = 1;
            }
            if (currentState[8] != null)
            {
               select = 5;
            }
            
            //Threat side chosen
            if (currentState[1] != null)
            {
               select = 0;
               firstSide5 = true;
            }
            
            if (currentState[5] != null)
            {
               select = 8;
               firstSide5 = true;
            }
            
            //Non-threat side chosen            
            if (currentState[3] != null)
            {
               select = 8;
               firstLate5 = true;
            }
            
            if (currentState[7] != null)
            {
               select = 0;
               firstLate5 = true;
            }
         }
         
         
         if (select3 == 2)
         {
            //diagonal chosen
            if (currentState[0] != null)
            {
               select = 3;
            }
            if (currentState[8] != null)
            {
               select = 7;
            }
            
            //Threat side chosen
            if (currentState[3] != null)
            {
               select = 0;
               firstSide5 = true;
            }
            
            if (currentState[7] != null)
            {
               select = 8;
               firstSide5 = true;
            }
            
            //Non-threat side chosen            
            if (currentState[1] != null)
            {
               select = 8;
               firstLate5 = true;
            }
            
            if (currentState[5] != null)
            {
               select = 0;
               firstLate5 = true;
            }
         }
         
         
         if (select3 == 0)
         {
            //diagonal chosen
            if (currentState[2] != null)
            {
               select = 5;
            }
            if (currentState[6] != null)
            {
               select = 7;
            }
            
            //Threat side chosen
            if (currentState[5] != null)
            {
               select = 2;
               firstSide5 = true;
            }
            
            if (currentState[3] != null)
            {
               select = 6;
               firstSide5 = true;
            }
            
            //Non-threat side chosen            
            if (currentState[1] != null)
            {
               select = 6;
               firstLate5 = true;
            }
            
            if (currentState[3] != null)
            {
               select = 2;
               firstLate5 = true;
            }
         }
        
      }
      
      select5 = select;
      return select;
   }
   
   private int getSixthTurn(String currentState[])
   {
      int select = -1;
      
      return select;
   }
   
   private int getSeventhTurn(String currentState[])
   {
      int select = -1;
      
      //GO FIRST, Enemy used side prior to 3
      if (firstSide3)
      {
         if (select5 == 0)
         {
            if (currentState[1] == null)
            {
               select = 1; //win
            }
            else
            {
               select = 8; //win
            }
         }
         
         if (select5 == 2)
         {
            if (currentState[5] == null)
            {
               select = 5; //win
            }
            else
            {
               select = 6; //win
            }
         }
      
         if (select5 == 6)
         {
            if (currentState[2] == null)
            {
               select = 2; //win
            }
            else
            {
               select = 3; //win
            }
         }
         
         if (select5 == 8)
         {
            if (currentState[0] == null)
            {
               select = 0; //win
            }
            else
            {
               select = 7; //win
            }
         }
         
      }
      
      
      //GO FIRST, Enemy used diagonal prior to 3
      if (firstDiag3)
      {
         if (firstSide5) //enemy used a threatening side
         {
            if (select3 == 8)
            {
               if (select5 == 1)
               {
                  if (currentState[7] == null)
                  {
                     select = 7; //win
                  }
                  else
                  {
                     select = 3;
                  }
               }
               else
               {
                  if (currentState[5] == null)
                  {
                     select = 5; //win
                  }
                  else
                  {
                     select = 1;
                  }
               }
            }
            
            if (select3 == 6)
            {
               if (select5 == 1)
               {
                  if (currentState[7] == null)
                  {
                     select = 7; //win
                  }
                  else
                  {
                     select = 5;
                  }
               }
               else
               {
                  if (currentState[3] == null)
                  {
                     select = 3; //win
                  }
                  else
                  {
                     select = 1;
                  }
               }
            }
            
            if (select3 == 2)
            {
               if (select5 == 3)
               {
                  if (currentState[5] == null)
                  {
                     select = 5; //win
                  }
                  else
                  {
                     select = 7;
                  }
               }
               else
               {
                  if (currentState[1] == null)
                  {
                     select = 1; //win
                  }
                  else
                  {
                     select = 3;
                  }
               }
            }
            
            
            if (select3 == 0)
            {
               if (select5 == 5)
               {
                  if (currentState[3] == null)
                  {
                     select = 3; //win
                  }
                  else
                  {
                     select = 7;
                  }
               }
               else
               {
                  if (currentState[1] == null)
                  {
                     select = 1; //win
                  }
                  else
                  {
                     select = 5;
                  }
               }
            }

            
         }
         else
         {
            if (firstLate5) //Enemy chose no-win scenario later in game
            {
               if (select3 == 8)
               {
                  if (select5 == 6)
                  {
                     if (currentState[2] == null)
                     {
                        select = 2; //win
                     }
                     else
                     {
                        select = 7; //win
                     }
                  }
                  else
                  {
                     if (currentState[5] == null)
                     {
                        select = 5; //win
                     }
                     else
                     {
                        select = 6; //win
                     }
                  }
               }
               
               if (select3 == 6)
               {
                  if (select5 == 8)
                  {
                     if (currentState[0] == null)
                     {
                        select = 0; //win
                     }
                     else
                     {
                        select = 7; //win
                     }
                  }
                  else
                  {
                     if (currentState[3] == null)
                     {
                        select = 3; //win
                     }
                     else
                     {
                        select = 8; //win
                     }
                  }
               }
               
               
               if (select3 == 2)
               {
                  if (select5 == 8)
                  {
                     if (currentState[0] == null)
                     {
                        select = 0; //win
                     }
                     else
                     {
                        select = 5; //win
                     }
                  }
                  else
                  {
                     if (currentState[1] == null)
                     {
                        select = 1; //win
                     }
                     else
                     {
                        select = 8; //win
                     }
                  }
               }
               
               
               if (select3 == 0)
               {
                  if (select5 == 6)
                  {
                     if (currentState[2] == null)
                     {
                        select = 2; //win
                     }
                     else
                     {
                        select = 3; //win
                     }
                  }
                  else
                  {
                     if (currentState[1] == null)
                     {
                        select = 1; //win
                     }
                     else
                     {
                        select = 6; //win
                     }
                  }
               }
               
            }
            else //enemy used a threatening diagonal
            {
               if (select3 == 8)
               {
                  if (select5 == 1)
                  {
                     if (currentState[7] == null)
                     {
                        select = 7; //win
                     }
                     else
                     {
                        select = 3;
                     }
                 
                  }
                  else
                  {
                     if (currentState[5] == null)
                     {
                        select = 5; //win
                     }
                     else
                     {
                        select = 1;
                     }
                  }
               }
               
               if (select3 == 6)
               {
                  if (select5 == 1)
                  {
                     if (currentState[7] == null)
                     {
                        select = 7; //win
                     }
                     else
                     {
                        select = 5;
                     }
                  }
                  else
                  {
                     if (currentState[3] == null)
                     {
                        select = 3; //win
                     }
                     else
                     {
                        select = 1;
                     }
                  }
               }
               
               if (select3 == 2)
               {
                  if (select5 == 3)
                  {
                     if (currentState[5] == null)
                     {
                        select = 5; //win
                     }
                     else
                     {
                        select = 7;
                     }
                  }
                  else
                  {
                     if (currentState[1] == null)
                     {
                        select = 1; //win
                     }
                     else
                     {
                        select = 3;
                     }
                  }
               }
               
               if (select3 == 0)
               {
                  if (select5 == 5)
                  {
                     if (currentState[3] == null)
                     {
                        select = 3;
                     }
                     else
                     {
                        select = 7;
                     }
                  }
                  else
                  {
                     if (currentState[1] == null)
                     {
                        select = 1;
                     }
                     else
                     {
                        select = 5;
                     }
                  }
               }
            
            
            }
         }
      }
      
      //No select 7, because there will only be one choice for 9.
      
      return select;
   }
   
   private int getEigthTurn(String currentState[])
   {
      int select = -1;
      
      return select;
   }
   
   private int getLastTurn(String currentState[])
   {
      int select = -1;
      
      for (int i=0; i < 9; i++)
      {
         if (currentState[i] != null)
         {
            select = i;
            break;
         }
      }
      
      return select;
   }
   
   
   
   
}
