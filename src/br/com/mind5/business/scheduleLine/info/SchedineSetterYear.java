package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class SchedineSetterYear extends InfoSetterTemplate<SchedineInfo> {
	
	@Override protected SchedineInfo setAttrHook(SchedineInfo recordInfo) {
		recordInfo.year = recordInfo.date.getYear();
		return recordInfo;
	}
}
