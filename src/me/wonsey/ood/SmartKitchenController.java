package me.wonsey.ood;

public class SmartKitchenController
{
   Command[] onCommands;
   Command[] offCommands;
   Command undoCommand;

   public SmartKitchenController()
   {
      onCommands = new Command[7];
      offCommands = new Command[7];

      Command noCommand = new NoCommand();
      for (int i = 0; i < 7; i++)
      {
         onCommands[i] = noCommand;
         offCommands[i] = noCommand;
      }
      undoCommand = noCommand;
   }

   public void setCommand(int slot, Command onCommand, Command offCommand)
   {
      onCommands[slot] = onCommand;
      offCommands[slot] = offCommand;
   }

   public void turnOn(int slot)
   {
      onCommands[slot].Execute();
      undoCommand = onCommands[slot];
   }

   public void turnOff(int slot)
   {
      offCommands[slot].Execute();
      undoCommand = offCommands[slot];
   }
   
   public void undoAction()
   {
      undoCommand.Undo();
   }

}