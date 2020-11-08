package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.paymentPartner.info.Paypar;

public final class TokemoipSetterCodPayPartner extends InfoSetterTemplate<TokemoipInfo> {
	
	@Override protected TokemoipInfo setAttrHook(TokemoipInfo recordInfo) {
		recordInfo.codPayPartner = Paypar.MOIP.getCodPayPartner();		
		return recordInfo;
	}
}
