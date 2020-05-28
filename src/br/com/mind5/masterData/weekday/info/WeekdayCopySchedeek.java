package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class WeekdayCopySchedeek extends InfoCopierOneToManyTemplate<WeekdayInfo, SchedeekInfo> {
	
	public WeekdayCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(SchedeekInfo source) {
		Set<WeekdayInfo> results = new HashSet<>();
		
		
		for (SchedeekdatInfo eachSchedeekdat : source.schedeekdates) {
			WeekdayInfo eachResult = new WeekdayInfo();
			
			eachResult.codWeekday = eachSchedeekdat.codWeekday;
			eachResult.codLanguage = eachSchedeekdat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
