package br.com.mind5.business.materialList.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatlisCopySchedmon extends InfoCopierOneToManyTemplate<MatlisInfo, SchedmonInfo>{
	
	public MatlisCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<MatlisInfo> makeCopyHook(SchedmonInfo source) {
		List<MatlisInfo> results = new ArrayList<>();
		
		if (source.schedonthats == null)
			return results;
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthats) {
			MatlisInfo eachResult = new MatlisInfo();
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codMat = eachSchedonthat.codMat;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		MatlisUniquifier uniquifier = new MatlisUniquifier();
		return uniquifier.uniquify(results);
	}
}
