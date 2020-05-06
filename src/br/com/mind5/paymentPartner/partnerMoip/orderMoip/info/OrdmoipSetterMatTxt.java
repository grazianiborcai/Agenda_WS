package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterMatTxt extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.productTxt = recordInfo.payordemData.matlisData.txtMat;
		recordInfo.detailTxt = recordInfo.payordemData.matlisData.txtMat;

		return recordInfo;
	}
}
