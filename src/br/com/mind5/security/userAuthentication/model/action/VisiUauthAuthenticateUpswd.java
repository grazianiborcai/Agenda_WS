package br.com.mind5.security.userAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdAuthUsername;

final class VisiUauthAuthenticateUpswd extends ActionVisitorTemplateAction<UauthInfo, UpswdInfo> {
	public VisiUauthAuthenticateUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UauthInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdAuthUsername(option).toAction();
	}
	
	
	
	@Override protected List<UauthInfo> toBaseClassHook(List<UauthInfo> baseInfos, List<UpswdInfo> results) {
		return baseInfos;
	}
}
