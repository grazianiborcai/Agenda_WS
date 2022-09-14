package br.com.mind5.business.employeeLunchTime.model.action;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.info.EmplutmSetterIsDeletedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmVisiEnforceIsDeletedOn extends ActionVisitorTemplateEnforce<EmplutmInfo> {
	
	public EmplutmVisiEnforceIsDeletedOn(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplutmInfo enforceHook(EmplutmInfo recordInfo) {
		InfoSetter<EmplutmInfo> attrSetter = new EmplutmSetterIsDeletedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
