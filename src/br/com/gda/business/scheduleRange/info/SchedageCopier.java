package br.com.gda.business.scheduleRange.info;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.info.InfoCopier;

public final class SchedageCopier {	
	public static SchedageInfo copyFromStolate(StolateInfo source) {
		InfoCopier<SchedageInfo, StolateInfo> copier = new SchedageCopyStolate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedageInfo> copyFromStolate(List<StolateInfo> sources) {
		InfoCopier<SchedageInfo, StolateInfo> copier = new SchedageCopyStolate();
		return copier.makeCopy(sources);
	}
}
