package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterValidFrom;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiEnforceValidFrom extends ActionVisitorTemplateEnforce<EmplateInfo> {
	
	public EmplateVisiEnforceValidFrom(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterValidFrom();
		return attrSetter.setAttr(recordInfo);
	}
}
