package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.business.customer.model.decisionTree.RootCusSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusMergeToSelect extends ActionVisitorTemplateMergeV2<CusInfo, CusInfo> {
	
	public VisiCusMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return RootCusSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
