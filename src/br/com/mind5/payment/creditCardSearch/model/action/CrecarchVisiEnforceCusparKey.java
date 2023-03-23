package br.com.mind5.payment.creditCardSearch.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.info.CrecarchSetterCusparKey;

public final class CrecarchVisiEnforceCusparKey extends ActionVisitorTemplateEnforce<CrecarchInfo> {
	
	public CrecarchVisiEnforceCusparKey(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecarchInfo enforceHook(CrecarchInfo recordInfo) {
		InfoSetter<CrecarchInfo> attrSetter = new CrecarchSetterCusparKey();
		return attrSetter.setAttr(recordInfo);
	}
}
