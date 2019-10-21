package br.com.mind5.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateMerger;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.decisionTree.RootStolarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolateMergeStolarch extends ActionVisitorTemplateMergeV2<StolateInfo, StolarchInfo> {
	
	public VisiStolateMergeStolarch(Connection conn, String schemaName) {
		super(conn, schemaName, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolarchInfo>> getTreeClassHook() {
		return RootStolarchSelect.class;
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> recordInfos, List<StolarchInfo> selectedInfos) {	
		return StolateMerger.mergeWithStolarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
