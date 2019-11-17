package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmplarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmplarchInfo, EmplarchInfo> {
	
	public VisiEmplarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplarchInfo>> getActionClassHook() {
		return StdEmplarchSelect.class;
	}
	
	
	
	@Override protected List<EmplarchInfo> mergeHook(List<EmplarchInfo> recordInfos, List<EmplarchInfo> selectedInfos) {	
		return EmplarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
