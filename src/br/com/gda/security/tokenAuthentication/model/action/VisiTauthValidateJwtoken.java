package br.com.gda.security.tokenAuthentication.model.action;

import java.sql.Connection;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.RootJwtokenValidate;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

final class VisiTauthValidateJwtoken extends ActionVisitorTemplateAction<TauthInfo, JwtokenInfo> {
	public VisiTauthValidateJwtoken(Connection conn, String schemaName) {
		super(conn, schemaName, TauthInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected ActionStd<JwtokenInfo> getActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new RootJwtokenValidate(option).toAction();
	}
}
