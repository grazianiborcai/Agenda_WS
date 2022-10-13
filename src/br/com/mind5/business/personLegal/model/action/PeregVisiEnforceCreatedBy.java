package br.com.mind5.business.personLegal.model.action;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<PeregInfo> {
	
	public PeregVisiEnforceCreatedBy(DeciTreeOption<PeregInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected PeregInfo enforceHook(PeregInfo recordInfo) {
		InfoSetter<PeregInfo> attrSetter = new PeregSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
