package br.com.mind5.business.employeeLunchTimeSearch.model.action;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchSetterEmposKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmarchVisiEnforceEmposKey extends ActionVisitorTemplateEnforce<EmplutmarchInfo> {
	
	public EmplutmarchVisiEnforceEmposKey(DeciTreeOption<EmplutmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplutmarchInfo enforceHook(EmplutmarchInfo recordInfo) {
		InfoSetter<EmplutmarchInfo> attrSetter = new EmplutmarchSetterEmposKey();
		return attrSetter.setAttr(recordInfo);
	}
}
