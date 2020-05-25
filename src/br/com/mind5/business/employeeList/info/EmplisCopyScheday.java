package br.com.mind5.business.employeeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class EmplisCopyScheday extends InfoCopierOneToManyTemplate<EmplisInfo, SchedayInfo> {
	
	public EmplisCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<EmplisInfo> makeCopyHook(SchedayInfo source) {
		List<EmplisInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedonthat : source.schedaytas) {
			EmplisInfo eachResult = new EmplisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codEmployee = eachSchedonthat.codEmployee;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<EmplisInfo> uniquifier = new EmplisUniquifier();
		return uniquifier.uniquify(results);	
	}
}
