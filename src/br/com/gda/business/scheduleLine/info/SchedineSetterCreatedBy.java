package br.com.gda.business.scheduleLine.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class SchedineSetterCreatedBy implements InfoSetter<SchedineInfo> {
	
	public SchedineInfo setAttr(SchedineInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
	
	
	
	private void checkArgument(SchedineInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
}
