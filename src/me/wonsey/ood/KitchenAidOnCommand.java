package me.wonsey.ood;

public class KitchenAidOnCommand implements Command
{
   KitchenAid kitchen_aid;

   public KitchenAidOnCommand(KitchenAid kitchen_aid)
   {
      this.kitchen_aid = kitchen_aid;
   }

   public void Execute()
   {
      this.kitchen_aid.on();
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }

}
