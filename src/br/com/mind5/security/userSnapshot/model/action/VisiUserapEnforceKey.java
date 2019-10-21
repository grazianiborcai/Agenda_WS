package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapSetterKey;

final class VisiUserapEnforceKey extends ActionVisitorTemplateEnforce<UserapInfo> {
	
	@Override protected UserapInfo enforceHook(UserapInfo recordInfo) {
		InfoSetter<UserapInfo> attrSetter = new UserapSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
