package br.com.mind5.business.calendarTimeEmployee.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class CalimempCopySchedeek extends InfoCopierOneToManyTemplate<CalimempInfo, SchedeekInfo> {
	
	public CalimempCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<CalimempInfo> makeCopyHook(SchedeekInfo source) {
		Set<CalimempInfo> results = new HashSet<>();
		
		for (CalateInfo eachCalate: source.calates) {
			if (eachCalate.date != null) {
				for (EmplresInfo eachEmplres : source.emplreses) {
					CalimempInfo eachResult = new CalimempInfo();
					
					eachResult.codOwner = source.codOwner;
					eachResult.codStore = source.codStore;
					eachResult.codEmployee = eachEmplres.codEmployee;
					eachResult.date = eachCalate.date;
					eachResult.username = eachCalate.username;
					eachResult.codLanguage = eachCalate.codLanguage;
					
					results.add(eachResult);
				}
			}
		}
		
		
		return new ArrayList<>(results);
	}
}
