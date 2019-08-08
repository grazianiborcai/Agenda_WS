package br.com.gda.security.userSnapshot.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.info.UserapSetterKey;

final class VisiUserapEnforceKey extends ActionVisitorTemplateEnforce<UserapInfo> {
	
	@Override protected UserapInfo enforceHook(UserapInfo recordInfo) {
		InfoSetter<UserapInfo> attrSetter = new UserapSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
