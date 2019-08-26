package br.com.gda.business.orderItemSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.gda.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdemrapMergeStolis extends ActionVisitorTemplateMergeV2<OrdemrapInfo, StolisInfo> {
	
	public VisiOrdemrapMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
