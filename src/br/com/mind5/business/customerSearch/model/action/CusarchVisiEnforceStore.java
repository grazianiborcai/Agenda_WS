package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchSetterStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiEnforceStore extends ActionVisitorTemplateEnforce<CusarchInfo> {
	
	public CusarchVisiEnforceStore(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	@Override protected CusarchInfo enforceHook(CusarchInfo recordInfo) {
		InfoSetter<CusarchInfo> attrSetter = new CusarchSetterStore();
		return attrSetter.setAttr(recordInfo);
	}
}
