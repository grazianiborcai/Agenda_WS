package br.com.mind5.business.calendarMoon.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MooncalCopySchedeek extends InfoCopierOneToManyTemplate<MooncalInfo, SchedeekInfo> {
	
	public MooncalCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<MooncalInfo> makeCopyHook(SchedeekInfo source) {
		Set<MooncalInfo> results = new HashSet<>();		
		
		for (SchedeekdatInfo eachSchedeekdat : source.schedeekdates) {
			MooncalInfo eachResult = new MooncalInfo();
			
			eachResult.moonDate = eachSchedeekdat.date;
			eachResult.codLanguage = eachSchedeekdat.codLanguage;
			eachResult.username = eachSchedeekdat.username;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
