package components;

import Tomasulo.Tomasulo;

public class FPMultipliers {
	private ReservationStation [] stations;
	
	public FPMultipliers() {
		this.stations = new ReservationStation [Tomasulo.mulReserveSpace];
	}
	
	public void run() {
		for (ReservationStation instruction : stations) {
			if (instruction.canExec()) {
				instruction.decCycles();
			}
		}
	}
	
	public int containsFreeStation() {
		for (int i = 0 ; i < stations.length ; i++) {
			ReservationStation instruction = stations[i];
			if (instruction == null)
				return i;
		}
		return -1;
	}
	
	public void addReservation(int index,ReservationStation reservationStation) {
		stations[index] = reservationStation;
	}
}
