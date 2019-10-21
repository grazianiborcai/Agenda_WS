package br.com.mind5.business.material.info;


import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class MatCopySchedmon extends InfoCopierOneToManyTemplate<MatInfo, SchedmonInfo>{
	
	public MatCopySchedmon() {
		super();
	}
	
	
	
	@Override protected List<MatInfo> makeCopyHook(SchedmonInfo source) {
		List<MatInfo> results = new ArrayList<>();
		
		if (source.schedonthats == null)
			return results;
		
		
		for (SchedonthatInfo eachSchedonthat : source.schedonthats) {
			MatInfo eachResult = new MatInfo();
			eachResult.codOwner = eachSchedonthat.codOwner;
			eachResult.codMat = eachSchedonthat.codMat;
			eachResult.codLanguage = eachSchedonthat.codLanguage;
			eachResult.username = eachSchedonthat.username;
			
			results.add(eachResult);
		}
		
		
		MatUniquifier uniquifier = new MatUniquifier();
		return uniquifier.uniquify(results);
	}
}
