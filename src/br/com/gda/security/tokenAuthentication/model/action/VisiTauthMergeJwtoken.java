package br.com.gda.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.jwtToken.info.JwtokenCopier;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.jwtToken.model.decisionTree.RootJwtokenParse;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthMergeJwtoken extends ActionVisitorTemplateMerge<TauthInfo, JwtokenInfo> {
	
	public VisiTauthMergeJwtoken(Connection conn, String schemaName) {
		super(conn, schemaName, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return RootJwtokenParse.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<TauthInfo>> getMergerClassHook() {
		return TauthMerger.class;
	}
}
