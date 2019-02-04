package br.com.gda.security.userAuthentication.model.action;

import java.sql.Connection;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userAuthentication.info.UauthInfo;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.decisionTree.RootUpswdAuth;

final class VisiUauthSelectUpswd extends ActionVisitorTemplateAction<UauthInfo, UpswdInfo> {
	public VisiUauthSelectUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UauthInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdAuth(option).toAction();
	}
}
