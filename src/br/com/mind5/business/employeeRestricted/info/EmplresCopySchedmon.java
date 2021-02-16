package br.com.mind5.business.employeeRestricted.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplresCopySchedmon extends InfoCopierOneToManyTemplate<EmplresInfo, SchedmonInfo> {
	
	public EmplresCopySchedmon() {
		super(new EmplresUniquifier());
	}
	
	
	
	@Override protected List<EmplresInfo> makeCopyHook(SchedmonInfo source) {
		List<EmplresInfo> results = new ArrayList<>();
		
		if (source.schedonthates == null)
			return results;
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthates) {
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
