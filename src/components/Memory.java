package components;

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
			}
		}
	}
	
	public void runStore() {
		for (ReservationStation instruction : storeBuffers) {
			if (instruction.canExec()) {
				instruction.decCycles();
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
}
