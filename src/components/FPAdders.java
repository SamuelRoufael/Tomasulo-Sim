package components;

import Tomasulo.Tomasulo;

public class FPAdders {
	private ReservationStation [] stations;

	public FPAdders() {
		this.stations = new ReservationStation [Tomasulo.addReserveSpace];
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