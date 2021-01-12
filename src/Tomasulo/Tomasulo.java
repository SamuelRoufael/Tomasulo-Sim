package Tomasulo;

import components.FPAdders;
import components.FPMultipliers;
import components.FPRegisters;
import components.InstructionQueue;
import components.Memory;
import stages.Exec;
import stages.Issue;
import stages.Write;

public class Tomasulo {
	public static FPAdders fpAdders;
	public static FPMultipliers fpMultipliers;
	public static FPRegisters fpRegisters;
	public static InstructionQueue instructionQueue;
	public static Memory memory;
	public static Issue issueStage;
	public static Exec executeStage;
	public static Write writeStage;
	public static int addReserveSpace;
	public static int mulReserveSpace;
	public static int loadReserveSpace;
	public static int storeReserveSpace;
	public static int addCycles;
	public static int subCycles;
	public static int mulCycles;
	public static int divCycles;
	public static int loadCycles;
	public static int storeCycles;
	public static int currentCycle;
	
	public static void main(String[] args) {
		
	}
	
}
