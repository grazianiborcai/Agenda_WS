package br.com.gda.business.ownerStore.model.action;

import java.sql.Connection;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.info.OwntoreMerger;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwntoreMergeToDelete extends ActionVisitorTemplateMerge<OwntoreInfo, OwntoreInfo> {
	
	public VisiOwntoreMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwntoreInfo>> getTreeClassHook() {
		return RootOwntoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OwntoreInfo>> getMergerClassHook() {
		return OwntoreMerger.class;
	}
}
