package br.com.mind5.masterData.dayParting.info;

import java.time.LocalTime;

public enum Daypart {
	MORNING(1), AFTERNOON(2), EVENING_NIGHT(3);
	
	private final int codDaypart;
	
	
	private Daypart(int cod) {
		codDaypart = cod;
	}
	
	
	
	public static Daypart of(LocalTime time) {
		if (time == null)
			return null;
		
		LocalTime morning = LocalTime.of(12, 00);
		LocalTime afternoon = LocalTime.of(18, 00);
		LocalTime night = LocalTime.of(23, 59);
		LocalTime tRounded = LocalTime.of(time.getHour(), time.getMinute());
		
		
		if (tRounded.isBefore(morning))
			return MORNING;
		
		if (tRounded.isBefore(afternoon))
			return AFTERNOON;
		
		if (tRounded.isBefore(night) || time.equals(night))
			return EVENING_NIGHT;
		
		
		return null;
	}
	
	
	
	public int getCodDaypart() {
		return codDaypart;
	}
}
