package br.com.gda.business.company.model.action;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompSetterCategOwner;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCompEnforceCategOwner extends ActionVisitorTemplateEnforce<CompInfo> {
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCategOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
