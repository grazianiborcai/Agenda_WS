package br.com.mind5.security.userAuthentication.model.action;

import java.sql.Connection;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdAuthUsername;

final class VisiUauthAuthenticateUpswd extends ActionVisitorTemplateAction<UauthInfo, UpswdInfo> {
	public VisiUauthAuthenticateUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UauthInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdAuthUsername(option).toAction();
	}
}
