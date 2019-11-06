package br.com.mind5.business.employeePositionSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmposarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmposarchInfo, EmposarchInfo> {
	
	public VisiEmposarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmposarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmposarchInfo>> getActionClassHook() {
		return StdEmposarchSelect.class;
	}
	
	
	
	@Override protected List<EmposarchInfo> mergeHook(List<EmposarchInfo> recordInfos, List<EmposarchInfo> selectedInfos) {	
		return EmposarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
