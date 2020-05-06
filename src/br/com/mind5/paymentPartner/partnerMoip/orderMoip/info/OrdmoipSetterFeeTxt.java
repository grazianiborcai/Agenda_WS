package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class OrdmoipSetterFeeTxt extends InfoSetterTemplate<OrdmoipInfo> {
	
	@Override protected OrdmoipInfo setAttrHook(OrdmoipInfo recordInfo) {
		recordInfo.productTxt = recordInfo.payordemData.txtFeeCateg;
		recordInfo.detailTxt = recordInfo.payordemData.txtFeeCateg;

		return recordInfo;
	}
}
