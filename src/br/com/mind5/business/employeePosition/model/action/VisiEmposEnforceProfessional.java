package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterProfessional;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposEnforceProfessional extends ActionVisitorTemplateEnforceV2<EmposInfo> {
	
	public VisiEmposEnforceProfessional(DeciTreeOption<EmposInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterProfessional();
		return attrSetter.setAttr(recordInfo);
	}
}
