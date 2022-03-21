package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusSetterAddressKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiEnforceAddressKey extends ActionVisitorTemplateEnforce<CusInfo> {
	
	public CusVisiEnforceAddressKey(DeciTreeOption<CusInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected CusInfo enforceHook(CusInfo recordInfo) {
		InfoSetter<CusInfo> attrSetter = new CusSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
