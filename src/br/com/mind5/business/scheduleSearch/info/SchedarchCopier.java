package br.com.mind5.business.scheduleSearch.info;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopier;

public final class SchedarchCopier {	
	public static SchedarchInfo copyFromSchedine(SchedineInfo source) {
		InfoCopier<SchedarchInfo, SchedineInfo> copier = new SchedarchCopySchedine();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedarchInfo> copyFromSchedine(List<SchedineInfo> sources) {
		InfoCopier<SchedarchInfo, SchedineInfo> copier = new SchedarchCopySchedine();
		return copier.makeCopy(sources);
	}
}
