package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	public EmposVisiEnforceCreatedBy(DeciTreeOption<EmposInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
