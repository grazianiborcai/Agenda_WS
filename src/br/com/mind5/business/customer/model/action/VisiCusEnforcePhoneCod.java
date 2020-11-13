package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterPhoneCod;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusEnforcePhoneCod extends ActionVisitorTemplateEnforce<CusInfo> {
	
	public VisiCusEnforcePhoneCod(DeciTreeOption<CusInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterPhoneCod();
		return attrSetter.setAttr(recordInfo);
	}
}
