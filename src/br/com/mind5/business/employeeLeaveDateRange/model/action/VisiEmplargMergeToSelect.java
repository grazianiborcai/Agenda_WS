package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmplargMergeToSelect extends ActionVisitorTemplateMerge<EmplargInfo, EmplargInfo> {
	
	public VisiEmplargMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplargInfo>> getActionClassHook() {
		return StdEmplargSelect.class;
	}
	
	
	
	@Override protected List<EmplargInfo> mergeHook(List<EmplargInfo> recordInfos, List<EmplargInfo> selectedInfos) {	
		return EmplargMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
