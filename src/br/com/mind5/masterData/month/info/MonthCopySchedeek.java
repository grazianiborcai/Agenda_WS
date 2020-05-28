package br.com.mind5.masterData.month.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MonthCopySchedeek extends InfoCopierOneToManyTemplate<MonthInfo, SchedeekInfo> {
	
	public MonthCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<MonthInfo> makeCopyHook(SchedeekInfo source) {
		Set<MonthInfo> results = new HashSet<>();
		
		
		for (SchedeekdatInfo eachSchedeekdat : source.schedeekdates) {
			MonthInfo eachResult = new MonthInfo();
			
			eachResult.month = eachSchedeekdat.month;
			eachResult.codLanguage = eachSchedeekdat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
