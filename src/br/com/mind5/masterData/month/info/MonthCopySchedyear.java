package br.com.mind5.masterData.month.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MonthCopySchedyear extends InfoCopierOneToManyTemplate<MonthInfo, SchedyearInfo> {
	
	public MonthCopySchedyear() {
		super();
	}
	
	
	
	@Override protected List<MonthInfo> makeCopyHook(SchedyearInfo source) {
		Set<MonthInfo> results = new HashSet<>();
		
		
		for (SchedyeratInfo eachSchedyerat : source.schedyerates) {
			MonthInfo eachResult = new MonthInfo();
			
			eachResult.month = eachSchedyerat.month;
			eachResult.codLanguage = eachSchedyerat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
