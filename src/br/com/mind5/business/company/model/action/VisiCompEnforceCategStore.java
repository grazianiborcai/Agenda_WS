package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterCategStore;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCompEnforceCategStore extends ActionVisitorTemplateEnforce<CompInfo> {
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterCategStore();
		return attrSetter.setAttr(recordInfo);
	}
}
