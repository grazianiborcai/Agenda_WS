package br.com.mind5.business.employeeRestricted.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplresCopySchedeek extends InfoCopierOneToManyTemplate<EmplresInfo, SchedeekInfo> {
	
	public EmplresCopySchedeek() {
		super(new EmplresUniquifier());
	}
	
	
	
	@Override protected List<EmplresInfo> makeCopyHook(SchedeekInfo source) {
		List<EmplresInfo> results = new ArrayList<>();
		
		if (source.schedeekdates == null)
			return results;
		
		
		for (SchedeekdatInfo eachSchedonthat : source.schedeekdates) {
			EmplresInfo eachResult = new EmplresInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codEmployee = eachSchedonthat.codEmployee;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		return results;
	}
}
