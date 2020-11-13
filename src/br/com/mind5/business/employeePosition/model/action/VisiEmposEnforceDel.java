package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposEnforceDel extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	public VisiEmposEnforceDel(DeciTreeOption<EmposInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
