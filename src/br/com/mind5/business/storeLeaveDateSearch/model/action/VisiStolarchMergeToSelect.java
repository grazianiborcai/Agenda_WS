package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiStolarchMergeToSelect extends ActionVisitorTemplateMergeV1<StolarchInfo, StolarchInfo> {
	
	public VisiStolarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StolarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StolarchInfo>> getActionClassHook() {
		return StdStolarchSelect.class;
	}
	
	
	
	@Override protected List<StolarchInfo> mergeHook(List<StolarchInfo> baseInfos, List<StolarchInfo> selectedInfos) {	
		return StolarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
