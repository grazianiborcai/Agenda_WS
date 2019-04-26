package br.com.gda.business.company.model.action;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompMerger;
import br.com.gda.business.company.model.decisionTree.RootCompSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCompMergeToDelete extends ActionVisitorTemplateMerge<CompInfo, CompInfo> {
	
	public VisiCompMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CompInfo>> getMergerClassHook() {
		return CompMerger.class;
	}
}
