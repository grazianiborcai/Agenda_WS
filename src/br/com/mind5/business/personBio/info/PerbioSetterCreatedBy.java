package br.com.mind5.business.personBio.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class PerbioSetterCreatedBy extends InfoSetterTemplate<PerbioInfo> {
	
	@Override protected PerbioInfo setAttrHook(PerbioInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
