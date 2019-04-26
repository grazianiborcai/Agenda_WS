package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStoreMergeUsername extends ActionVisitorTemplateMerge<StoreInfo, UsernameInfo> {
	
	public VisiStoreMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return UsernameCopier.copyFromStore(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StoreInfo>> getMergerClassHook() {
		return StoreMerger.class;
	}
}
