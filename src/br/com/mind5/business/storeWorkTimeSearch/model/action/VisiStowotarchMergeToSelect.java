package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStowotarchMergeToSelect extends ActionVisitorTemplateMerge<StowotarchInfo, StowotarchInfo> {
	
	public VisiStowotarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StowotarchInfo>> getActionClassHook() {
		return StdStowotarchSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> mergeHook(List<StowotarchInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
