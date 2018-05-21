package edepotSystem;

import java.time.LocalDate;

public interface Scheduleable {
	public boolean isFree(LocalDate startDate, LocalDate endDate);
	
	public WorkSchedule getWorkSchedule(String clientName);
	


	void setSchedule(WorkSchedule addedSchdedule);
		
	
}
