package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterCategStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompEnforceCategStore extends ActionVisitorTemplateEnforceV2<CompInfo> {
	
	public VisiCompEnforceCategStore(DeciTreeOption<CompInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCategStore();
		return attrSetter.setAttr(recordInfo);
	}
}
