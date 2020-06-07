package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposEnforceCreatedBy extends ActionVisitorTemplateEnforceV2<EmposInfo> {
	
	public VisiEmposEnforceCreatedBy(DeciTreeOption<EmposInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
