package br.com.mind5.business.personLegal.model.action;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregSetterAddressKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiEnforceAddressKey extends ActionVisitorTemplateEnforce<PeregInfo> {
	
	public PeregVisiEnforceAddressKey(DeciTreeOption<PeregInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected PeregInfo enforceHook(PeregInfo recordInfo) {
		InfoSetter<PeregInfo> attrSetter = new PeregSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
