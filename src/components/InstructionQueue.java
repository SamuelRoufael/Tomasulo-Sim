package components;

import java.util.ArrayList;
import Tomasulo.Instruction;

public class InstructionQueue {
	ArrayList<Instruction> instructions;
	int nextInLine = 0;
	
	public InstructionQueue() {
		
	}
	
	public Instruction fetchInstruction() {
		return instructions.get(nextInLine);
	}
	
	public void incCounter() {
		nextInLine++;
	}
	
	public boolean isEmpty() {
		return nextInLine == instructions.size();
	}
}
