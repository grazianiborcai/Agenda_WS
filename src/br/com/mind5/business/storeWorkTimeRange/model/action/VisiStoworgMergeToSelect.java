package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiStoworgMergeToSelect extends ActionVisitorTemplateMergeV2<StoworgInfo, StoworgInfo> {
	
	public VisiStoworgMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StoworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoworgInfo>> getActionClassHook() {
		return StdStoworgSelect.class;
	}
	
	
	
	@Override protected List<StoworgInfo> mergeHook(List<StoworgInfo> recordInfos, List<StoworgInfo> selectedInfos) {	
		return StoworgMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
