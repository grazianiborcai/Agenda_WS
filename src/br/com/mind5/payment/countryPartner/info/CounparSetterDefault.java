package br.com.mind5.payment.countryPartner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CounparSetterDefault extends InfoSetterTemplate<CounparInfo> {
	
	@Override protected CounparInfo setAttrHook(CounparInfo recordInfo) {
		recordInfo.isDefault = true;
		return recordInfo;
	}	
}
