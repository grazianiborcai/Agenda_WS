package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompEnforceLChanged extends ActionVisitorTemplateEnforce<CompInfo> {
	
	public VisiCompEnforceLChanged(DeciTreeOption<CompInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
