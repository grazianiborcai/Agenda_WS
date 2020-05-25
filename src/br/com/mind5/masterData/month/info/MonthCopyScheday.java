package br.com.mind5.masterData.month.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MonthCopyScheday extends InfoCopierOneToManyTemplate<MonthInfo, SchedayInfo> {
	
	public MonthCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<MonthInfo> makeCopyHook(SchedayInfo source) {
		List<MonthInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedayta : source.schedaytas) {
			MonthInfo eachResult = new MonthInfo();
			
			eachResult.month = eachSchedayta.month;
			eachResult.codLanguage = eachSchedayta.codLanguage;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<MonthInfo> uniquifier = new MonthUniquifier();
		return uniquifier.uniquify(results);
	}
}
