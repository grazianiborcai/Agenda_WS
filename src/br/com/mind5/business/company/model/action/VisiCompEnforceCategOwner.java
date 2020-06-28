package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterCategOwner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompEnforceCategOwner extends ActionVisitorTemplateEnforceV2<CompInfo> {
	
	public VisiCompEnforceCategOwner(DeciTreeOption<CompInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCategOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
