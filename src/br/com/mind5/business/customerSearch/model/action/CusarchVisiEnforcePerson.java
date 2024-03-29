package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchSetterPerson;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchVisiEnforcePerson extends ActionVisitorTemplateEnforce<CusarchInfo> {
	
	public CusarchVisiEnforcePerson(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	@Override protected CusarchInfo enforceHook(CusarchInfo recordInfo) {
		InfoSetter<CusarchInfo> attrSetter = new CusarchSetterPerson();
		return attrSetter.setAttr(recordInfo);
	}
}
