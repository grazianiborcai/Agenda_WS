package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateEnforceCreatedOn extends ActionVisitorTemplateEnforceV2<EmplateInfo> {
	
	public VisiEmplateEnforceCreatedOn(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
