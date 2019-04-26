package br.com.gda.security.storeAuthorization.model.action;

import java.sql.Connection;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.info.StorauthMerger;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStorauthMergeUsername extends ActionVisitorTemplateMerge<StorauthInfo, UsernameInfo> {
	
	public VisiStorauthMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StorauthInfo>> getMergerClassHook() {
		return StorauthMerger.class;
	}
}
