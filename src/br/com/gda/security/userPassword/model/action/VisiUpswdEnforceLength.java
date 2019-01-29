package br.com.gda.security.userPassword.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.info.UpswdSetterLength;

final class VisiUpswdEnforceLength extends ActionVisitorTemplateEnforce<UpswdInfo> {
	
	@Override protected UpswdInfo enforceHook(UpswdInfo recordInfo) {
		InfoSetter<UpswdInfo> attrSetter = new UpswdSetterLength();
		return attrSetter.setAttr(recordInfo);
	}
}
