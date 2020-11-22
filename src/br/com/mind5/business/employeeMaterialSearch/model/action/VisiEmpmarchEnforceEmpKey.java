package br.com.mind5.business.employeeMaterialSearch.model.action;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchSetterEmpKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmarchEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpmarchInfo> {
	
	public VisiEmpmarchEnforceEmpKey(DeciTreeOption<EmpmarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpmarchInfo enforceHook(EmpmarchInfo recordInfo) {
		InfoSetter<EmpmarchInfo> attrSetter = new EmpmarchSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
