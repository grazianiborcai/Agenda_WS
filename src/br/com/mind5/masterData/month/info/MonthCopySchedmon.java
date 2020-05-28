package br.com.mind5.masterData.month.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MonthCopySchedmon extends InfoCopierOneToManyTemplate<MonthInfo, SchedmonInfo> {
	
	public MonthCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<MonthInfo> makeCopyHook(SchedmonInfo source) {
		Set<MonthInfo> results = new HashSet<>();
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthates) {
			MonthInfo eachResult = new MonthInfo();
			
			eachResult.month = eachSchedonthat.month;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
