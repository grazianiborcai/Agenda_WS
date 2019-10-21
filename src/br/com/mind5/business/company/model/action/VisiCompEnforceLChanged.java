package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiCompEnforceLChanged extends ActionVisitorTemplateEnforce<CompInfo> {
	
	@Override protected CompInfo enforceHook(CompInfo recordInfo) {
		InfoSetter<CompInfo> attrSetter = new CompSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
