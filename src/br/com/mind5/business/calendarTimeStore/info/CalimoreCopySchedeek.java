package br.com.mind5.business.calendarTimeStore.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class CalimoreCopySchedeek extends InfoCopierOneToManyTemplate<CalimoreInfo, SchedeekInfo> {
	
	public CalimoreCopySchedeek() {
		super();
	}
	
	
	
	@Override protected List<CalimoreInfo> makeCopyHook(SchedeekInfo source) {
		Set<CalimoreInfo> results = new HashSet<>();
		
		for (CalateInfo eachCalate: source.calates) {
			if (eachCalate.date != null) {
				CalimoreInfo eachResult = new CalimoreInfo();
				
				eachResult.codOwner = source.codOwner;
				eachResult.codStore = source.codStore;
				eachResult.date = eachCalate.date;
				eachResult.username = eachCalate.username;
				eachResult.codLanguage = eachCalate.codLanguage;
				
				results.add(eachResult);
			}
		}
		
		
		return new ArrayList<>(results);
	}
}
