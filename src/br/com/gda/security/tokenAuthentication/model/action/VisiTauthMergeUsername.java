package br.com.gda.security.tokenAuthentication.model.action;

import java.sql.Connection;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;
import br.com.gda.security.tokenAuthentication.info.TauthMerger;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiTauthMergeUsername extends ActionVisitorTemplateMerge_<TauthInfo, UsernameInfo> {
	
	public VisiTauthMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<TauthInfo>> getMergerClassHook() {
		return TauthMerger.class;
	}
}
