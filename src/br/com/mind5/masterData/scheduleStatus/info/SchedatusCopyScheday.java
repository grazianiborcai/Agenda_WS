package br.com.mind5.masterData.scheduleStatus.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedatusCopyScheday extends InfoCopierOneToManyTemplate<SchedatusInfo, SchedayInfo> {
	
	public SchedatusCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<SchedatusInfo> makeCopyHook(SchedayInfo source) {
		List<SchedatusInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedonthat : source.schedaytas) {
			SchedatusInfo eachResult = new SchedatusInfo();
			
			eachResult.codScheduleStatus = eachSchedonthat.codScheduleStatus;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<SchedatusInfo> uniquifier = new SchedatusUniquifier();
		return uniquifier.uniquify(results);
	}
}
