package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterUserData;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusEnforceUserData extends ActionVisitorTemplateEnforceV2<CusInfo> {
	
	public VisiCusEnforceUserData(DeciTreeOption<CusInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterUserData();
		return attrSetter.setAttr(recordInfo);
	}
}
