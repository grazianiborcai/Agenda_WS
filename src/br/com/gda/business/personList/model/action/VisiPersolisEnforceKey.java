package br.com.gda.business.personList.model.action;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.info.PersolisSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersolisEnforceKey extends ActionVisitorTemplateEnforce<PersolisInfo> {

	@Override protected PersolisInfo enforceHook(PersolisInfo recordInfo) {
		InfoSetter<PersolisInfo> attrSetter = new PersolisSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
