package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class CrecardSetterUpperCase extends InfoSetterTemplate<CrecardInfo> {
	
	@Override protected CrecardInfo setAttrHook(CrecardInfo recordInfo) {
		if(recordInfo.nameHolder != null)
			recordInfo.nameHolder = recordInfo.nameHolder.toUpperCase();
		
		if(recordInfo.creditCardBrand != null)
			recordInfo.creditCardBrand = recordInfo.creditCardBrand.toUpperCase();
		
		return recordInfo;
	}
}
