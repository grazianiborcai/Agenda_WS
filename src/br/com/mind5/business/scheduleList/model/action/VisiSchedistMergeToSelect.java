package br.com.mind5.business.scheduleList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.business.scheduleList.info.SchedistMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiSchedistMergeToSelect extends ActionVisitorTemplateMerge<SchedistInfo, SchedistInfo> {
	
	public VisiSchedistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<SchedistInfo>> getActionClassHook() {
		return StdSchedistSelect.class;
	}
	
	
	
	@Override protected List<SchedistInfo> mergeHook(List<SchedistInfo> recordInfos, List<SchedistInfo> selectedInfos) {	
		return SchedistMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
