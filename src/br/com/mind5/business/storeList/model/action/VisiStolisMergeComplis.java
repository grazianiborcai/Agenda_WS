package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.decisionTree.RootComplisSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolisMergeComplis extends ActionVisitorTemplateMergeV2<StolisInfo, ComplisInfo> {
	
	public VisiStolisMergeComplis(Connection conn, String schemaName) {
		super(conn, schemaName, ComplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ComplisInfo>> getTreeClassHook() {
		return RootComplisSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<ComplisInfo> selectedInfos) {	
		return StolisMerger.mergeWithComplis(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
