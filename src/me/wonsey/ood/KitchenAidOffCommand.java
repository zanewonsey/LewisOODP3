package me.wonsey.ood;

public class KitchenAidOffCommand implements Command
{
   KitchenAid kitchen_aid;

   public KitchenAidOffCommand(KitchenAid kitchen_aid)
   {
      this.kitchen_aid = kitchen_aid;
   }

   public void Execute()
   {
      this.kitchen_aid.off();
   }

   @Override
   public void Undo()
   {
      // TODO Auto-generated method stub
      
   }

}
