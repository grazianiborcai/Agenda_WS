package br.com.gda.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.decisionTree.RootCompSelect;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.info.StolisMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolisMergeComp extends ActionVisitorTemplateMerge<StolisInfo, CompInfo> {
	
	public VisiStolisMergeComp(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<CompInfo> selectedInfos) {	
		return StolisMerger.mergeWithComp(selectedInfos, recordInfos);
	}
}
