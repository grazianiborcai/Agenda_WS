package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<EmplateInfo> {
	
	public EmplateVisiEnforceCreatedOn(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
