package components;

import java.util.ArrayList;

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
				if (instruction.getCycles() == 0)
					instruction.getInstruction().setExecEndCycle(Tomasulo.currentCycle);
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

	public void clearReservation(int index) {
		stations[index] = null;
	}

	public ArrayList<ReservationStation> readyToWrite(){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();

		for (ReservationStation instruction : stations) {
			if (instruction.getCycles() == -1)
				list.add(instruction);
		}	
		return list;
	}

	public ArrayList<ReservationStation> dependentOne(String nameRS){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();

		for (ReservationStation instruction : stations) {
			if (instruction.getQj() == nameRS || instruction.getQk() == nameRS)
				list.add(instruction);
		}	
		return list;
	}
	
	public ArrayList<ReservationStation> dependentOnOnly(String nameRS){
		ArrayList<ReservationStation> list = new ArrayList<ReservationStation>();

		for (ReservationStation instruction : stations) {
			if ((instruction.getQj() == nameRS && instruction.getQk() == null) || (instruction.getQj() == null && instruction.getQk() == nameRS))
				list.add(instruction);
		}	
		return list;
	}
}


