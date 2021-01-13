package components;

import java.util.ArrayList;

import Tomasulo.Tomasulo;

public class Memory {
	private ReservationStation [] loadBuffers;
	private ReservationStation [] storeBuffers;
	
	public Memory() {
		loadBuffers = new ReservationStation [Tomasulo.loadReserveSpace];
		storeBuffers = new ReservationStation [Tomasulo.storeReserveSpace];
	}
	
	public void runLoad() {
		for (ReservationStation instruction : loadBuffers) {
			if (instruction.canExec()) {
				instruction.decCycles();
				if (instruction.getCycles() == 0)
					instruction.getInstruction().setExecEndCycle(Tomasulo.currentCycle);
			}
		}
	}
	
	public void runStore() {
		for (ReservationStation instruction : storeBuffers) {
			if (instruction.canExec()) {
				instruction.decCycles();
				if (instruction.getCycles() == 0)
					instruction.getInstruction().setExecEndCycle(Tomasulo.currentCycle);
			}
		}
	}
	
	public int loadContainsFreeStation() {
		for (int i = 0 ; i < loadBuffers.length ; i++) {
			ReservationStation instruction = loadBuffers[i];
			if (instruction == null)
				return i;
		}
		return -1;
	}
	
	public int storeContainsFreeStation() {
		for (int i = 0 ; i < storeBuffers.length ; i++) {
			ReservationStation instruction = storeBuffers[i];
			if (instruction == null)
				return i;
		}
		return -1;
	}
	
	public void addReservationLoad(int index ,ReservationStation reservationStation) {
		loadBuffers[index] = reservationStation;
	}
	
	public void addReservationStore(int index,ReservationStation reservationStation) {
		storeBuffers[index] = reservationStation;
	}
	
	public void clearReservationLoad(int index) {
		loadBuffers[index] = null;
	}
	
	public void clearReservationStore(int index) {
		storeBuffers[index] = null;
	}
	
	public ArrayList<ReservationStation> loadReadyToWrite(){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();
		
		for (ReservationStation instruction : loadBuffers) {
			if (instruction.getCycles() == -1)
				list.add(instruction);
		}	
		return list;
	}
	
	public ArrayList<ReservationStation> storeReadyToWrite(){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();
		
		for (ReservationStation instruction : loadBuffers) {
			if (instruction.getCycles() == -1)
				list.add(instruction);
		}	
		return list;
	}
	
	public ArrayList<ReservationStation> storeDependentOne(String nameRS){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();

		for (ReservationStation instruction : storeBuffers) {
			if (instruction.getQj() == nameRS)
				list.add(instruction);
		}	
		return list;
	}
}
