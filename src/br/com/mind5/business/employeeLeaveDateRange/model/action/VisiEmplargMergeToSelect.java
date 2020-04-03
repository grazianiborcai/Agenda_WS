package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiEmplargMergeToSelect extends ActionVisitorTemplateMergeV1<EmplargInfo, EmplargInfo> {
	
	public VisiEmplargMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmplargInfo>> getActionClassHook() {
		return StdEmplargSelect.class;
	}
	
	
	
	@Override protected List<EmplargInfo> mergeHook(List<EmplargInfo> recordInfos, List<EmplargInfo> selectedInfos) {	
		return EmplargMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
