package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class WeekdayCopyScheday extends InfoCopierOneToManyTemplate<WeekdayInfo, SchedayInfo> {
	
	public WeekdayCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(SchedayInfo source) {
		Set<WeekdayInfo> results = new HashSet<>();
		
		
		for (SchedaytaInfo eachSchedayta : source.schedaytas) {
			WeekdayInfo eachResult = new WeekdayInfo();
			
			eachResult.codWeekday = eachSchedayta.codWeekday;
			eachResult.codLanguage = eachSchedayta.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
