package br.com.mind5.business.companyList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.info.ComplisMerger;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.model.decisionTree.RootComparchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiComplisMergeComparch extends ActionVisitorTemplateMergeV2<ComplisInfo, ComparchInfo> {
	
	public VisiComplisMergeComparch(Connection conn, String schemaName) {
		super(conn, schemaName, ComparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComparchInfo>> getTreeClassHook() {
		return RootComparchSelect.class;
	}
	
	
	
	@Override protected List<ComplisInfo> mergeHook(List<ComplisInfo> recordInfos, List<ComparchInfo> selectedInfos) {	
		return ComplisMerger.mergeWithComparch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
