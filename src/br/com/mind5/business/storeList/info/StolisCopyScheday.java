package br.com.mind5.business.storeList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisCopyScheday extends InfoCopierOneToManyTemplate<StolisInfo, SchedayInfo> {
	
	public StolisCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<StolisInfo> makeCopyHook(SchedayInfo source) {
		List<StolisInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedonthat : source.schedaytas) {
			StolisInfo eachResult = new StolisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codStore = eachSchedonthat.codStore;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();
		return uniquifier.uniquify(results);	
	}
}
