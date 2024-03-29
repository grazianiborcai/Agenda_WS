package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisSetterPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiEnforcePersonKey extends ActionVisitorTemplateEnforce<EmplisInfo> {
	
	public EmplisVisiEnforcePersonKey(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplisInfo enforceHook(EmplisInfo recordInfo) {
		InfoSetter<EmplisInfo> attrSetter = new EmplisSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
