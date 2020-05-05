package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterCreatedBy extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
