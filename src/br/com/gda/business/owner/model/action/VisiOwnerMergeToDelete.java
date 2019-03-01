package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeToDelete extends ActionVisitorTemplateMerge<OwnerInfo, OwnerInfo> {
	
	public VisiOwnerMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerInfo>> getTreeClassHook() {
		return RootOwnerSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
}
