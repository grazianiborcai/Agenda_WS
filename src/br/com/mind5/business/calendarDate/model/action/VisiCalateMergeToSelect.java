package br.com.mind5.business.calendarDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCalateMergeToSelect extends ActionVisitorTemplateMerge<CalateInfo, CalateInfo> {
	
	public VisiCalateMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CalateInfo>> getActionClassHook() {
		return StdCalateSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalateMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
