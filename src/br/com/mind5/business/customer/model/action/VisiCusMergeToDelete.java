package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.customer.model.decisionTree.RootCusSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCusMergeToDelete extends ActionVisitorTemplateMergeV2<CusInfo, CusInfo> {
	
	public VisiCusMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return RootCusSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
