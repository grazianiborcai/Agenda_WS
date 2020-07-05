package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterPersonKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusEnforcePersonKey extends ActionVisitorTemplateEnforceV2<CusInfo> {
	
	public VisiCusEnforcePersonKey(DeciTreeOption<CusInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterPersonKey();
		return attrSetter.setAttr(recordInfo);
	}
}
