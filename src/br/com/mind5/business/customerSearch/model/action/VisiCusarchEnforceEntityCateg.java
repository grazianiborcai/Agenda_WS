package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchSetterCodEntityCateg;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusarchEnforceEntityCateg extends ActionVisitorTemplateEnforceV2<CusarchInfo> {
	
	public VisiCusarchEnforceEntityCateg(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	@Override protected CusarchInfo enforceHook(CusarchInfo recordInfo) {
		InfoSetter<CusarchInfo> attrSetter = new CusarchSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
