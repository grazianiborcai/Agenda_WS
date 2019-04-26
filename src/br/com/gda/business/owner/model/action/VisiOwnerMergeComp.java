package br.com.gda.business.owner.model.action;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.decisionTree.RootCompSelect;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeComp extends ActionVisitorTemplateMerge<OwnerInfo, CompInfo> {
	
	public VisiOwnerMergeComp(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
}
