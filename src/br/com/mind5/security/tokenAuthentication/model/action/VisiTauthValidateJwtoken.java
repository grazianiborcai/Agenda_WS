package br.com.mind5.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenValidate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthValidateJwtoken extends ActionVisitorTemplateActionV1<TauthInfo, JwtokenInfo> {
	public VisiTauthValidateJwtoken(Connection conn, String schemaName) {
		super(conn, schemaName, TauthInfo.class, JwtokenInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<JwtokenInfo> getActionHook(DeciTreeOption<JwtokenInfo> option) {
		return new RootJwtokenValidate(option).toAction();
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> toBaseClassHook(List<TauthInfo> baseInfos, List<JwtokenInfo> results) {
		return TauthMerger.mergeWithJwtoken(baseInfos, results);
	}
}
