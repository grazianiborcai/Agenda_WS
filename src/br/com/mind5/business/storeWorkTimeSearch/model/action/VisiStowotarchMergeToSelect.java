package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiStowotarchMergeToSelect extends ActionVisitorTemplateMergeV2<StowotarchInfo, StowotarchInfo> {
	
	public VisiStowotarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StowotarchInfo>> getActionClassHook() {
		return StdStowotarchSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> mergeHook(List<StowotarchInfo> recordInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
