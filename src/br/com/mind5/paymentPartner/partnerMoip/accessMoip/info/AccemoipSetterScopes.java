package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class AccemoipSetterScopes extends InfoSetterTemplate<AccemoipInfo> {
	
	@Override protected AccemoipInfo setAttrHook(AccemoipInfo recordInfo) {
		String[] allScopes = {"REFUND", "RECEIVE_FUNDS"};
		recordInfo.scopes = allScopes;
		return recordInfo;
	}
}
