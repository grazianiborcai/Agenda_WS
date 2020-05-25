package br.com.mind5.masterData.weekday.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class WeekdayCopyScheday extends InfoCopierOneToManyTemplate<WeekdayInfo, SchedayInfo> {
	
	public WeekdayCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<WeekdayInfo> makeCopyHook(SchedayInfo source) {
		List<WeekdayInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedayta : source.schedaytas) {
			WeekdayInfo eachResult = new WeekdayInfo();
			
			eachResult.codWeekday = eachSchedayta.codWeekday;
			eachResult.codLanguage = eachSchedayta.codLanguage;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<WeekdayInfo> uniquifier = new WeekdayUniquifier();
		return uniquifier.uniquify(results);
	}
}
