package br.com.mind5.business.employeeLunchTime.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class EmplutmSetterIsDeletedOn extends InfoSetterTemplate<EmplutmInfo> {
	
	@Override protected EmplutmInfo setAttrHook(EmplutmInfo recordInfo) {
		recordInfo.isDeleted = true;
		return recordInfo;
	}
}
