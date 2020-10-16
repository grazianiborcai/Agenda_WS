package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmposSetterProfessional extends InfoSetterTemplate<EmposInfo> {
	
	@Override protected EmposInfo setAttrHook(EmposInfo recordInfo) {
		recordInfo.codPosition = 7;
		return recordInfo;
	}
}
