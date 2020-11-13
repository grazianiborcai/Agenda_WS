package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterPhoneKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusEnforcePhoneKey extends ActionVisitorTemplateEnforce<CusInfo> {
	
	public VisiCusEnforcePhoneKey(DeciTreeOption<CusInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterPhoneKey();
		return attrSetter.setAttr(recordInfo);
	}
}
