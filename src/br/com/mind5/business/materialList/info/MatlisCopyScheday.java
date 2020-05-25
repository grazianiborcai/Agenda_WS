package br.com.mind5.business.materialList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatlisCopyScheday extends InfoCopierOneToManyTemplate<MatlisInfo, SchedayInfo> {
	
	public MatlisCopyScheday() {
		super();
	}
	
	
	
	@Override protected List<MatlisInfo> makeCopyHook(SchedayInfo source) {
		List<MatlisInfo> results = new ArrayList<>();
		
		if (source.schedaytas == null)
			return results;
		
		
		for (SchedaytaInfo eachSchedonthat : source.schedaytas) {
			MatlisInfo eachResult = new MatlisInfo();
			
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codMat = eachSchedonthat.codMat;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		InfoUniquifier<MatlisInfo> uniquifier = new MatlisUniquifier();
		return uniquifier.uniquify(results);	
	}
}
