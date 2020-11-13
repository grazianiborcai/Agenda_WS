package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplateEnforceDel extends ActionVisitorTemplateEnforce<EmplateInfo> {
	
	public VisiEmplateEnforceDel(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
