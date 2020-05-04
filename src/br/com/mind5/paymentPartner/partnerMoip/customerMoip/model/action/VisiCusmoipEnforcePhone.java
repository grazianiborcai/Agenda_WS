package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipSetterPhone;

final class VisiCusmoipEnforcePhone extends ActionVisitorTemplateEnforceV2<CusmoipInfo> {
	
	public VisiCusmoipEnforcePhone(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterPhone();
		return setter.setAttr(recordInfo);
	}
}
