package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchSetterCategCus;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchEnforceCategCus extends ActionVisitorTemplateEnforce<PerarchInfo> {
	
	public VisiPerarchEnforceCategCus(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	

	@Override protected PerarchInfo enforceHook(PerarchInfo recordInfo) {
		InfoSetter<PerarchInfo> attrSetter = new PerarchSetterCategCus();
		return attrSetter.setAttr(recordInfo);
	}
}
