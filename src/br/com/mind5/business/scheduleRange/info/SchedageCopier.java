package br.com.mind5.business.scheduleRange.info;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.info.InfoCopier;

public final class SchedageCopier {	
	public static SchedageInfo copyFromEmplate(EmplateInfo source) {
		InfoCopier<SchedageInfo, EmplateInfo> copier = new SchedageCopyEmplate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedageInfo> copyFromEmplate(List<EmplateInfo> sources) {
		InfoCopier<SchedageInfo, EmplateInfo> copier = new SchedageCopyEmplate();
		return copier.makeCopy(sources);
	}
	
	
	
	public static SchedageInfo copyFromEmpos(EmposInfo source) {
		InfoCopier<SchedageInfo, EmposInfo> copier = new SchedageCopyEmpos();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedageInfo> copyFromEmpos(List<EmposInfo> sources) {
		InfoCopier<SchedageInfo, EmposInfo> copier = new SchedageCopyEmpos();
		return copier.makeCopy(sources);
	}
	
	
	
	public static SchedageInfo copyFromStolate(StolateInfo source) {
		InfoCopier<SchedageInfo, StolateInfo> copier = new SchedageCopyStolate();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SchedageInfo> copyFromStolate(List<StolateInfo> sources) {
		InfoCopier<SchedageInfo, StolateInfo> copier = new SchedageCopyStolate();
		return copier.makeCopy(sources);
	}
}
