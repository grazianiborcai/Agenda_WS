package br.com.gda.security.userPassword.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.info.UpswdSetterHashToMatch;

final class VisiUpswdEnforceHashToMatch extends ActionVisitorTemplateEnforce<UpswdInfo> {
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterHashToMatch();
		return attrSetter.setAttr(recordInfo);
	}
}
