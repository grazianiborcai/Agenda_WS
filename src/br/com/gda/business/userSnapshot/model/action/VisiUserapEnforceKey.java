package br.com.gda.business.userSnapshot.model.action;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.info.UserapSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserapEnforceKey extends ActionVisitorTemplateEnforce<UserapInfo> {
	
	@Override protected UserapInfo enforceHook(UserapInfo recordInfo) {
		InfoSetter<UserapInfo> attrSetter = new UserapSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
