package br.com.mind5.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenValidate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthValidateJwtoken extends ActionVisitorTemplateAction<TauthInfo, JwtokenInfo> {
	public VisiTauthValidateJwtoken(Connection conn, String schemaName) {
		super(conn, schemaName, TauthInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected ActionStd<JwtokenInfo> getActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new RootJwtokenValidate(option).toAction();
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> toBaseClassHook(List<TauthInfo> baseInfos, List<JwtokenInfo> results) {
		return TauthMerger.mergeWithJwtoken(baseInfos, results);
	}
}
