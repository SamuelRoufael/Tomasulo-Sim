package stages;

import java.util.ArrayList;

import Tomasulo.Tomasulo;
import components.ReservationStation;

public class Write {
	
	private ReservationStation bestToBeWritten;
	private int maxNumberOfDependencies;
	
	public void run() {
		ArrayList<ReservationStation> fpAddersReadyToBeWritten = Tomasulo.fpAdders.readyToWrite();
		ArrayList<ReservationStation> fpMultipliersReadyToBeWritten = Tomasulo.fpMultipliers.readyToWrite();
		ArrayList<ReservationStation> loadReadyToBeWritten = Tomasulo.memory.loadReadyToWrite();
		ArrayList<ReservationStation> storeReadyToBeWritten = Tomasulo.memory.storeReadyToWrite();
	}
}
