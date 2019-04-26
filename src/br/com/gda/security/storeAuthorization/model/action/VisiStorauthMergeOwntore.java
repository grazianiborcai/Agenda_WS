package br.com.gda.security.storeAuthorization.model.action;

import java.sql.Connection;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;
import br.com.gda.security.storeAuthorization.info.StorauthMerger;

final class VisiStorauthMergeOwntore extends ActionVisitorTemplateMerge<StorauthInfo, OwntoreInfo> {
	
	public VisiStorauthMergeOwntore(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwntoreInfo>> getTreeClassHook() {
		return RootOwntoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StorauthInfo>> getMergerClassHook() {
		return StorauthMerger.class;
	}
}
