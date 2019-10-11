package br.com.gda.business.storeLeaveDateSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.gda.business.storeLeaveDateSearch.info.StolarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiStolarchMergeToSelect extends ActionVisitorTemplateMergeV2<StolarchInfo, StolarchInfo> {
	
	public VisiStolarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StolarchInfo>> getActionClassHook() {
		return StdStolarchSelect.class;
	}
	
	
	
	@Override protected List<StolarchInfo> mergeHook(List<StolarchInfo> recordInfos, List<StolarchInfo> selectedInfos) {	
		return StolarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
