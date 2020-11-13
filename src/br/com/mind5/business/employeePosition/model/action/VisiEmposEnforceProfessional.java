package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterProfessional;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposEnforceProfessional extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	public VisiEmposEnforceProfessional(DeciTreeOption<EmposInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterProfessional();
		return attrSetter.setAttr(recordInfo);
	}
}
