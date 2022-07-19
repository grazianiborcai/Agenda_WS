package br.com.mind5.payment.customerPartnerSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchSetterUserKey;

public final class CusparchVisiEnforceUserKey extends ActionVisitorTemplateEnforce<CusparchInfo> {
	
	public CusparchVisiEnforceUserKey(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CusparchInfo enforceHook(CusparchInfo recordInfo) {
		InfoSetter<CusparchInfo> attrSetter = new CusparchSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
