package br.com.mind5.business.personLegal.model.action;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregSetterPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiEnforcePersonKey extends ActionVisitorTemplateEnforce<PeregInfo> {
	
	public PeregVisiEnforcePersonKey(DeciTreeOption<PeregInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected PeregInfo enforceHook(PeregInfo recordInfo) {
		InfoSetter<PeregInfo> attrSetter = new PeregSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
