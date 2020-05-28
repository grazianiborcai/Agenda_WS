package br.com.mind5.business.moonCalendar.info;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MooncalCopySchedmon extends InfoCopierOneToManyTemplate<MooncalInfo, SchedmonInfo> {
	
	public MooncalCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<MooncalInfo> makeCopyHook(SchedmonInfo source) {
		Set<MooncalInfo> results = new HashSet<>();		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthates) {
			MooncalInfo eachResult = new MooncalInfo();
			
			eachResult.moonDate = eachSchedonthat.date;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		return new ArrayList<>(results);
	}
}
