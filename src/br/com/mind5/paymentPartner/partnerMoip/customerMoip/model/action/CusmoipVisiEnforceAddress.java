package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipSetterAddress;

public final class CusmoipVisiEnforceAddress extends ActionVisitorTemplateEnforce<CusmoipInfo> {
	
	public CusmoipVisiEnforceAddress(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusmoipInfo enforceHook(CusmoipInfo recordInfo) {
		InfoSetter<CusmoipInfo> setter = new CusmoipSetterAddress();
		return setter.setAttr(recordInfo);
	}
}
