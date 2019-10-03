package br.com.gda.business.company.model.action;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompSetterCategStore;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCompEnforceCategStore extends ActionVisitorTemplateEnforce<CompInfo> {
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCategStore();
		return attrSetter.setAttr(recordInfo);
	}
}
