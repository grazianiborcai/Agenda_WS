package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
