package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStoworgMergeToSelect extends ActionVisitorTemplateMerge<StoworgInfo, StoworgInfo> {
	
	public VisiStoworgMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoworgInfo>> getActionClassHook() {
		return StdStoworgSelect.class;
	}
	
	
	
	@Override protected List<StoworgInfo> mergeHook(List<StoworgInfo> baseInfos, List<StoworgInfo> selectedInfos) {	
		return StoworgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
