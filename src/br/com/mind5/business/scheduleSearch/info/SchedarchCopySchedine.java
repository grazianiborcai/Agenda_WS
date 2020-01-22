package br.com.mind5.business.scheduleSearch.info;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SchedarchCopySchedine extends InfoCopierTemplate<SchedarchInfo, SchedineInfo> {
	
	public SchedarchCopySchedine() {
		super();
	}
	
	
	
	@Override protected SchedarchInfo makeCopyHook(SchedineInfo source) {
		SchedarchInfo result = new SchedarchInfo();
		
		result.codOwner = source.codOwner;
		result.codMat = source.codMat;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.date = source.date;
		result.beginTime = source.beginTime;
		result.endTime = source.endTime;
		result.username = source.username;	
		
		return result;
	}
}
