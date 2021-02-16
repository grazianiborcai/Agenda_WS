package br.com.mind5.business.employeeRestricted.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class EmplresCopyScheday extends InfoCopierOneToManyTemplate<EmplresInfo, SchedayInfo> {
	
	public EmplresCopyScheday() {
		super(new EmplresUniquifier());
	}
	
	
	
	@Override protected List<EmplresInfo> makeCopyHook(SchedayInfo source) {
		List<EmplresInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedonthat : source.schedaytas) {
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
