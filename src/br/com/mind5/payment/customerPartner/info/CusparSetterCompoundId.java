package br.com.mind5.payment.customerPartner.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CusparSetterCompoundId extends InfoSetterTemplate<CusparInfo> {
	
	@Override protected CusparInfo setAttrHook(CusparInfo recordInfo) {
		recordInfo.compoundId = String.valueOf(recordInfo.codOwner) 
				              + "-" 
				              + String.valueOf(recordInfo.codUser);
		
		return recordInfo;
	}	
}
