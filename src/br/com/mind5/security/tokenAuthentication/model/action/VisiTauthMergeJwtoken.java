package br.com.mind5.security.tokenAuthentication.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.jwtToken.info.JwtokenCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;
import br.com.mind5.security.jwtToken.model.decisionTree.RootJwtokenParse;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;
import br.com.mind5.security.tokenAuthentication.info.TauthMerger;

final class VisiTauthMergeJwtoken extends ActionVisitorTemplateMergeV1<TauthInfo, JwtokenInfo> {
	
	public VisiTauthMergeJwtoken(Connection conn, String schemaName) {
		super(conn, schemaName, JwtokenInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<JwtokenInfo>> getTreeClassHook() {
		return RootJwtokenParse.class;
	}
	
	
	
	@Override protected List<JwtokenInfo> toActionClassHook(List<TauthInfo> baseInfos) {
		return JwtokenCopier.copyFromTauth(baseInfos);
	}
	
	
	
	@Override protected List<TauthInfo> mergeHook(List<TauthInfo> baseInfos, List<JwtokenInfo> selectedInfos) {	
		return TauthMerger.mergeWithJwtoken(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
