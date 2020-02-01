package me.wonsey.ood;

public class StoveOffCommand implements Command
{
   Stove s;
   
   public StoveOffCommand(Stove s)
   {
      this.s = s;
   }

   @Override
   public void Execute()
   {
      s.off();
      s.coolDown();
      
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }
}
