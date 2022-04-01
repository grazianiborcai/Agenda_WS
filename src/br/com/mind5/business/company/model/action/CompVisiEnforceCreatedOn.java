package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<CompInfo> {
	
	public CompVisiEnforceCreatedOn(DeciTreeOption<CompInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
