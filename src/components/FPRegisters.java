package components;

public class FPRegisters {
	private String [] registers;
	
	public FPRegisters() {
		registers = new String [32];
	}
	
	public String getAt(int index) {
		return registers[index];
	}
	
	public void clearAt(int index) {
		registers[index] = null; 
	}
	
	public void reserveAt(int index,String reservationName) {
		registers[index] = reservationName;
	}	
}
