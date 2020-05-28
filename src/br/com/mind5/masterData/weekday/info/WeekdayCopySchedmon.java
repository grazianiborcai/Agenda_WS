package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class WeekdayCopySchedmon extends InfoCopierOneToManyTemplate<WeekdayInfo, SchedmonInfo> {
	
	public WeekdayCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(SchedmonInfo source) {
		Set<WeekdayInfo> results = new HashSet<>();
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthats) {
			WeekdayInfo eachResult = new WeekdayInfo();
			
			eachResult.codWeekday = eachSchedonthat.codWeekday;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
