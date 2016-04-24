public class TicTacToeAIAlternate
{   

   boolean firstSide3 = false; //Did enemy use a side prior to 3?
   boolean firstDiag3 = false; //Did enemy use a diagonal prior to 3?
   boolean firstLate5 = false; //Did enemy choose a no-win scenario prior to 5?
   boolean firstSide5 = false; //Did enemy choose a threatening side prior to 5?
   
   int select1 = -1; //Move used on turn 1
   int select3 = -1; //Move used on turn 3
   int select5 = -1; //Move used on turn 5
   int select7 = -1; //Move used on turn 7
   
   int select2 = -1; //Move used on turn 2
   int select4 = -1; //Move used on turn 4
   int select6 = -1; //Move used on turn 6
   int select8 = -1; //Move used on turn 8
   
   int space8_1 = -1; //First open space on turn 8
   int space8_2 = -1; //Second open space on turn 8
   int chance8_1 = -1; //Whether first space is win, block, or neither
   int chance8_2 = -1; //Whether second space is win, block, or neither
   
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
      
      select1 = select;
      return select;
   }
   
   private int getSecondTurn(String currentState[])
   {
      int select = -1;
      
      //If center is taken, O takes a corner. If not, O takes the center.
      if (currentState[4] != null)
         select = 0;
      else
         select = 4;
      
      select2 = select;
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
      
      if (select2 == 0)
      {
         if (currentState[1] != null)
            select = 7;
         else if (currentState[2] != null)
            select = 6;
         else if (currentState[3] != null)
            select = 5;
         else if (currentState[5] != null)
            select = 3;
         else if (currentState[6] != null || currentState[8] != null)
            select = 2;
         else if (currentState[7] != null)
            select = 1;
      }
      else if (select2 == 4)
      {
         if (currentState[0] != null)
         {
            if (currentState[1] != null)
               select = 2;
            else if (currentState[2] != null || currentState[8] != null)
               select = 1;
            else if (currentState[3] != null)
               select = 6;
            else if (currentState[5] != null)
               select = 7;
            else if (currentState[6] != null)
               select = 3;
            else if (currentState[7] != null)
               select = 5;
         }
         else if (currentState[1] != null)
         {
            if (currentState[2] != null || currentState[5] != null || currentState[7] != null)
               select = 0;
            else if (currentState[3] != null)
               select = 2;
            else if (currentState[6] != null)
               select = 5;
            else if (currentState[8] != null)
               select = 3;
         }
         else if (currentState[2] != null)
         {
            if (currentState[3] != null)
               select = 7;
            else if (currentState[5] != null)
               select = 8;
            else if (currentState[6] != null)
               select = 1;
            else if (currentState[7] != null)
               select = 3;
            else if (currentState[8] != null)
               select = 5;
         }
         else if (currentState[3] != null)
         {
            if (currentState[5] != null || currentState[6] != null || currentState[7] != null)
               select = 0;
            else if (currentState[8] != null)
               select = 1;
         }
         else if (currentState[5] != null)
         {
            if (currentState[6] != null)
               select = 1;
            else if (currentState[7] != null || currentState[8] != null)
               select = 2;
         }
         else if (currentState[6] != null)
         {
            if (currentState[7] != null)
               select = 8;
            else if (currentState[8] != null)
               select = 7;
         }
         else if (currentState[7] != null && currentState[8] != null)
            select = 6;
      }
      
      select4 = select;
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
      
      if (select2 == 0)
      {
         if (select4 == 1)
         {
            if (currentState[2] == null)
               select = 2; //win
            else
               select = 6;
         }
         else if (select4 == 2)
         {
            if (currentState[1] == null)
               select = 1; //win
            else
               select = 7;
         }
         else if (select4 == 3)
         {
            if (currentState[6] == null)
               select = 6; //win
            else
               select = 2;
         }
         else if (select4 == 5)
         {
            if (currentState[1] != null)
               select = 7;
            else if (currentState[2] != null)
               select = 6;
            else if (currentState[6] != null)
               select = 2;
            else
               select = 1;
         }
         else if (select4 == 6)
         {
            if (currentState[3] == null)
               select = 3; //win
            else
               select = 5;
         }
         else if (select4 == 7)
         {
            if (currentState[2] != null)
               select = 6;
            else if (currentState[3] != null)
               select = 5;
            else if (currentState[6] != null)
               select = 2;
            else
               select = 3;
         }
      }
      else if (select2 == 4)
      {
         if (select4 == 0)
         {
            if (currentState[8] == null)
               select = 8; //win
            else
            {
               if (currentState[2] != null)
                  select = 5;
               else if (currentState[5] != null)
                  select = 2;
               else if (currentState[6] != null)
                  select = 7;
               else if (currentState[7] != null)
                  select = 6;
               // else if (currentState[1] != null && currentState[3] != null) ???
            }
         }
         else if (select4 == 1)
         {
            if (currentState[7] == null)
               select = 7; //win
            else
            {
               if (currentState[0] != null && currentState[2] != null)
                  select = 3;
               else if (currentState[6] != null)
                  select = 8;
               else if (currentState[8] != null)
                  select = 6;
               // else if (currentState[3] != null && currentState[5] != null) ???
            }
         }
         else if (select4 == 2)
         {
            if (currentState[6] == null)
               select = 6; //win
            else
            {
               if (currentState[0] != null)
                  select = 3;
               else if (currentState[3] != null)
                  select = 0;
               else if (currentState[7] != null)
                  select = 8;
               else if (currentState[8] != null)
                  select = 7;
               // else if (currentState[1] != null && currentState[5] != null) ???
            }
         }
         else if (select4 == 3)
         {
            if (currentState[5] == null)
               select = 5; //win
            else
            {
               if (currentState[0] != null && currentState[6] != null)
                  select = 1;
               else if (currentState[2] != null)
                  select = 8;
               else if (currentState[8] != null)
                  select = 2;
               // else if (currentState[1] != null && currentState[7] != null) ???
            }
         }
         else if (select4 == 5)
         {
            if (currentState[3] == null)
               select = 3; //win
            else
            {
               if (currentState[2] != null && currentState[8] != null)
                  select = 1;
               else if (currentState[0] != null)
                  select = 6;
               else if (currentState[6] != null)
                  select = 0;
               // else if (currentState[1] != null && currentState[7] != null) ???
            }
         }
         else if (select4 == 6)
         {
            if (currentState[2] == null)
               select = 2; //win
            else
            {
               if (currentState[0] != null)
                  select = 1;
               else if (currentState[1] != null)
                  select = 0;
               else if (currentState[5] != null)
                  select = 8;
               else if (currentState[8] != null)
                  select = 5;
               // else if (currentState[3] != null && currentState[7] != null) ???
            }
         }
         else if (select4 == 7)
         {
            if (currentState[1] == null)
               select = 1; //win
            else
            {
               if (currentState[6] != null && currentState[8] != null)
                  select = 3;
               else if (currentState[0] != null)
                  select = 2;
               else if (currentState[2] != null)
                  select = 0;
               // else if (currentState[3] != null && currentState[5] != null) ???
            }
         }
         else if (select4 == 8)
         {
            if (currentState[0] == null)
               select = 0; //win
            else
            {
               if (currentState[1] != null)
                  select = 2;
               else if (currentState[2] != null)
                  select = 1;
               else if (currentState[3] != null)
                  select = 6;
               else if (currentState[6] != null)
                  select = 3;
               // else if (currentState[5] != null && currentState[7] != null) ???
            }
         }
      }
      
      select6 = select;
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
      
      select7 = select;
      return select;
   }
   
   private int getEigthTurn(String currentState[])
   {
      int select = -1;
      
      //Check each square to find the two remaining empty spaces.
      //Then check whether playing in either square results in a win, block, or neither.
      if (currentState[0] == null)
      {
         space8_1 = 0;
         
         if (currentState[1] == currentState[2])
         {
            if (select2 == 1 || select4 == 1 || select6 == 1)
               chance8_1 = 0; //potential win
            else if (select1 == 1 || select3 == 1 || select5 == 1 || select7 == 1)
               chance8_1 = 1; //potential block
            else
               chance8_1 = 2; //neither
         }
         if (currentState[4] == currentState[8])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
               chance8_1 = 0; //potential win
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
                  chance8_1 = 1; //potential block
            }
         }
         if (currentState[3] == currentState[6])
         {
            if (select2 == 3 || select4 == 3 || select6 == 3)
               chance8_1 = 0; //potential win
            else if (select1 == 3 || select3 == 3 || select5 == 3 || select7 == 3)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
                  chance8_1 = 1; //potential block
            }
         }
      }
      if (currentState[1] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 1;
         else
            space8_2 = 1;
            
         if (currentState[0] == currentState[2])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[4] == currentState[7])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[2] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 2;
         else
            space8_2 = 2;

         if (currentState[0] == currentState[1])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[4] == currentState[6])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
         if (currentState[5] == currentState[8])
         {
            if (select2 == 5 || select4 == 5 || select6 == 5)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[3] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 3;
         else
            space8_2 = 3;
         if (currentState[0] == currentState[6])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[4] == currentState[5])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[4] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 4;
         else
            space8_2 = 4;

         if (currentState[0] == currentState[8])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[1] == currentState[7])
         {
            if (select2 == 1 || select4 == 1 || select6 == 1)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 1 || select3 == 1 || select5 == 1 || select7 == 1)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
         if (currentState[2] == currentState[6])
         {
            if (select2 == 2 || select4 == 2 || select6 == 2)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 2 || select3 == 2 || select5 == 2 || select7 == 2)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
         if (currentState[3] == currentState[5])
         {
            if (select2 == 3 || select4 == 3 || select6 == 3)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 3 || select3 == 3 || select5 == 3 || select7 == 3)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[5] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 5;
         else
            space8_2 = 5;
            
         if (currentState[2] == currentState[8])
         {
            if (select2 == 2 || select4 == 2 || select6 == 2)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 2 || select3 == 2 || select5 == 2 || select7 == 2)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[3] == currentState[4])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[6] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 6;
         else
            space8_2 = 6;
            
         if (currentState[0] == currentState[3])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[2] == currentState[4])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
         if (currentState[7] == currentState[8])
         {
            if (select2 == 7 || select4 == 7 || select6 == 7)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 7 || select3 == 7 || select5 == 7 || select7 == 7)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[7] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 7;
         else
            space8_2 = 7;
            
         if (currentState[6] == currentState[8])
         {
            if (select2 == 6 || select4 == 6 || select6 == 6)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 6 || select3 == 6 || select5 == 6 || select7 == 6)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[1] == currentState[4])
         {
            if (select2 == 4 || select4 == 4 || select6 == 4)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 4 || select3 == 4 || select5 == 4 || select7 == 4)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }
      if (currentState[8] == null)
      {
         if (space8_1 == -1) //if this is the first empty space found
            space8_1 = 8;
         else
            space8_2 = 8;
            
         if (currentState[0] == currentState[4])
         {
            if (select2 == 0 || select4 == 0 || select6 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 0 || select3 == 0 || select5 == 0 || select7 == 0)
            {
               if (space8_1 == -1)
                  chance8_1 = 1; //potential block
               else
                  chance8_2 = 1;
            }
            else
            {
               if (space8_1 == -1)
                  chance8_1 = 2; //neither
               else
                  chance8_2 = 2;
            }
         }
         if (currentState[2] == currentState[5])
         {
            if (select2 == 2 || select4 == 2 || select6 == 2)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 2 || select3 == 2 || select5 == 2 || select7 == 2)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
         if (currentState[6] == currentState[7])
         {
            if (select2 == 7 || select4 == 7 || select6 == 7)
            {
               if (space8_1 == -1)
                  chance8_1 = 0; //potential win
               else
                  chance8_2 = 0;
            }
            else if (select1 == 7 || select3 == 7 || select5 == 7 || select7 == 7)
            {
               if (chance8_1 != 0) //don't overwrite a potential win with a potential block
               {
                  if (space8_1 == -1)
                     chance8_1 = 1; //potential block
                  else
                     chance8_2 = 1;
               }
            }
         }
      }

      //Select the empty square that gives the best results.
      //A "win (0)" is preferable to a "block (1)" is preferable to "neither (2)"
      if (chance8_1 < chance8_2) //First square is better than second square
         select = space8_1;
      else if (chance8_1 > chance8_2) //Second square is better than first square
         select = space8_2;
      else if (chance8_1 == chance8_2) //Both squares would provide a win, a block, or neither
         select = space8_1;
      
      select8 = select;
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
