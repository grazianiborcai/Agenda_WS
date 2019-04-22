package br.com.gda.business.customerSearch.model.action;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.info.CusarchSetterCodEntityCateg;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCusarchCusEnforceEntityCateg extends ActionVisitorTemplateEnforce<CusarchInfo> {
	
	@Override protected CusarchInfo enforceHook(CusarchInfo recordInfo) {
		InfoSetter<CusarchInfo> attrSetter = new CusarchSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
