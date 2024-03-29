package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchSetterCategEmp;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchVisiEnforceCategEmp extends ActionVisitorTemplateEnforce<PerarchInfo> {
	
	public PerarchVisiEnforceCategEmp(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	

	@Override protected PerarchInfo enforceHook(PerarchInfo recordInfo) {
		InfoSetter<PerarchInfo> attrSetter = new PerarchSetterCategEmp();
		return attrSetter.setAttr(recordInfo);
	}
}
