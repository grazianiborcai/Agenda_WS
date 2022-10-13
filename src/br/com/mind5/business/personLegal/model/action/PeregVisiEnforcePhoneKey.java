package br.com.mind5.business.personLegal.model.action;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregSetterPhoneKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiEnforcePhoneKey extends ActionVisitorTemplateEnforce<PeregInfo> {
	
	public PeregVisiEnforcePhoneKey(DeciTreeOption<PeregInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected PeregInfo enforceHook(PeregInfo recordInfo) {
		InfoSetter<PeregInfo> attrSetter = new PeregSetterPhoneKey();
		return attrSetter.setAttr(recordInfo);
	}
}
