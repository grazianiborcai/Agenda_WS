package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchSetterCategEmp;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiPerarchEnforceCategEmp extends ActionVisitorTemplateEnforceV1<PerarchInfo> {

	@Override protected PerarchInfo enforceHook(PerarchInfo recordInfo) {
		InfoSetter<PerarchInfo> attrSetter = new PerarchSetterCategEmp();
		return attrSetter.setAttr(recordInfo);
	}
}
