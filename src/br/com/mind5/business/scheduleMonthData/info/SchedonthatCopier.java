package br.com.mind5.business.scheduleMonthData.info;

import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.info.InfoCopier;

public final class SchedonthatCopier {
	public static SchedonthatInfo copyFromSchedmon(SchedmonInfo source) {
		InfoCopier<SchedonthatInfo, SchedmonInfo> copier = new SchedonthatCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedonthatInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopier<SchedonthatInfo, SchedmonInfo> copier = new SchedonthatCopySchedmon();
		return copier.makeCopy(sources);
	}
}
