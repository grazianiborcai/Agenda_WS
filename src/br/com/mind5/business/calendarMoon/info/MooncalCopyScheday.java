package br.com.mind5.business.calendarMoon.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MooncalCopyScheday extends InfoCopierOneToManyTemplate<MooncalInfo, SchedayInfo> {
	
	public MooncalCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<MooncalInfo> makeCopyHook(SchedayInfo source) {
		Set<MooncalInfo> results = new HashSet<>();		
		
		for (SchedaytaInfo eachSchedayta : source.schedaytas) {
			MooncalInfo eachResult = new MooncalInfo();
			
			eachResult.moonDate = eachSchedayta.date;
			eachResult.codLanguage = eachSchedayta.codLanguage;
			eachResult.username = eachSchedayta.username;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
