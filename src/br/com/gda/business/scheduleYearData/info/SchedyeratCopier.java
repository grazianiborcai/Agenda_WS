package br.com.gda.business.scheduleYearData.info;

import java.util.List;

import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.info.InfoCopier;

public final class SchedyeratCopier {
	public static SchedyeratInfo copyFromSchedyear(SchedyearInfo source) {
		InfoCopier<SchedyeratInfo, SchedyearInfo> copier = new SchedyeratCopySchedyear();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedyeratInfo> copyFromSchedyear(List<SchedyearInfo> sources) {
		InfoCopier<SchedyeratInfo, SchedyearInfo> copier = new SchedyeratCopySchedyear();
		return copier.makeCopy(sources);
	}
}
