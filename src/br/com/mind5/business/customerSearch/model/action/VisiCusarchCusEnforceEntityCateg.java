package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchSetterCodEntityCateg;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCusarchCusEnforceEntityCateg extends ActionVisitorTemplateEnforce<CusarchInfo> {
	
	@Override protected CusarchInfo enforceHook(CusarchInfo recordInfo) {
		InfoSetter<CusarchInfo> attrSetter = new CusarchSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
