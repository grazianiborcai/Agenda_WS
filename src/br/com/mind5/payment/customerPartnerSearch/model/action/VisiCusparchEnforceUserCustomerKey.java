package br.com.mind5.payment.customerPartnerSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchSetterUserCustomerKey;

final class VisiCusparchEnforceUserCustomerKey extends ActionVisitorTemplateEnforce<CusparchInfo> {
	
	public VisiCusparchEnforceUserCustomerKey(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusparchInfo enforceHook(CusparchInfo recordInfo) {
		InfoSetter<CusparchInfo> attrSetter = new CusparchSetterUserCustomerKey();
		return attrSetter.setAttr(recordInfo);
	}
}
