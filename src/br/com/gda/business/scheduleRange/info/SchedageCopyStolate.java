package br.com.gda.business.scheduleRange.info;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.info.InfoCopierTemplate;

final class SchedageCopyStolate extends InfoCopierTemplate<SchedageInfo, StolateInfo> {
	
	public SchedageCopyStolate() {
		super();
	}
	
	
	
	@Override protected SchedageInfo makeCopyHook(StolateInfo source) {
		SchedageInfo result = new SchedageInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		result.dateValidFrom = source.dateValidFrom;
		result.dateValidTo = source.dateValidTo;
		result.timeValidFrom = source.timeValidFrom;
		result.timeValidTo = source.timeValidTo;
		return result;
	}
}
