package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisSetterRestricted;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersolisEnforceRestricted extends ActionVisitorTemplateEnforce<PersolisInfo> {

	@Override protected PersolisInfo enforceHook(PersolisInfo recordInfo) {
		InfoSetter<PersolisInfo> attrSetter = new PersolisSetterRestricted();
		return attrSetter.setAttr(recordInfo);
	}
}
