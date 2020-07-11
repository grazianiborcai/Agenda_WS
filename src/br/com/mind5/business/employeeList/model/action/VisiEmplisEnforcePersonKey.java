package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisSetterPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplisEnforcePersonKey extends ActionVisitorTemplateEnforceV2<EmplisInfo> {
	
	public VisiEmplisEnforcePersonKey(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplisInfo enforceHook(EmplisInfo recordInfo) {
		InfoSetter<EmplisInfo> attrSetter = new EmplisSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
