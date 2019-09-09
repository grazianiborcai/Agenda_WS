package br.com.gda.business.scheduleWeekData.info;

import java.util.List;

import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.info.InfoCopier;

public final class SchedeekdatCopier {
	public static SchedeekdatInfo copyFromSchedmon(SchedmonInfo source) {
		InfoCopier<SchedeekdatInfo, SchedmonInfo> copier = new SchedeekdatCopySchedmon();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedeekdatInfo> copyFromSchedmon(List<SchedmonInfo> sources) {
		InfoCopier<SchedeekdatInfo, SchedmonInfo> copier = new SchedeekdatCopySchedmon();
		return copier.makeCopy(sources);
	}
}
