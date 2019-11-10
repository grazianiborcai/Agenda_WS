package br.com.mind5.business.storeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmMerger;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.RootStowotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStowotmMergeStowotarch extends ActionVisitorTemplateMergeV2<StowotmInfo, StowotarchInfo> {
	
	public VisiStowotmMergeStowotarch(Connection conn, String schemaName) {
		super(conn, schemaName, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotarchInfo>> getTreeClassHook() {
		return RootStowotarchSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> mergeHook(List<StowotmInfo> recordInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotmMerger.mergeWithStowotarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
