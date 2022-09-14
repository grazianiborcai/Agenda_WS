package br.com.mind5.business.employeeLunchTime.model.action;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmSetterEmposKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiEnforceEmposKey extends ActionVisitorTemplateEnforce<EmplutmInfo> {
	
	public EmplutmVisiEnforceEmposKey(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplutmInfo enforceHook(EmplutmInfo recordInfo) {
		InfoSetter<EmplutmInfo> attrSetter = new EmplutmSetterEmposKey();
		return attrSetter.setAttr(recordInfo);
	}
}
