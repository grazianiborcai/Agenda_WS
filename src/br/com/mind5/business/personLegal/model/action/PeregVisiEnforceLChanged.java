package br.com.mind5.business.personLegal.model.action;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiEnforceLChanged extends ActionVisitorTemplateEnforce<PeregInfo> {
	
	public PeregVisiEnforceLChanged(DeciTreeOption<PeregInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected PeregInfo enforceHook(PeregInfo recordInfo) {
		InfoSetter<PeregInfo> attrSetter = new PeregSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
