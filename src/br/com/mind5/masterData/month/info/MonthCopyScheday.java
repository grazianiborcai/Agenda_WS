package br.com.mind5.masterData.month.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MonthCopyScheday extends InfoCopierOneToManyTemplate<MonthInfo, SchedayInfo> {
	
	public MonthCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<MonthInfo> makeCopyHook(SchedayInfo source) {
		Set<MonthInfo> results = new HashSet<>();
		
		
		for (SchedaytaInfo eachSchedayta : source.schedaytas) {
			MonthInfo eachResult = new MonthInfo();
			
			eachResult.month = eachSchedayta.month;
			eachResult.codLanguage = eachSchedayta.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
