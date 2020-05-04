package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipSetterSetup;

final class VisiCusmoipEnforceSetup extends ActionVisitorTemplateEnforceV2<CusmoipInfo> {
	
	public VisiCusmoipEnforceSetup(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterSetup();
		return setter.setAttr(recordInfo);
	}
}
