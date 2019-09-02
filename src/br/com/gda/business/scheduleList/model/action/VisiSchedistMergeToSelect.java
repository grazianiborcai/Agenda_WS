package br.com.gda.business.scheduleList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleList.info.SchedistInfo;
import br.com.gda.business.scheduleList.info.SchedistMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedistMergeToSelect extends ActionVisitorTemplateMergeV2<SchedistInfo, SchedistInfo> {
	
	public VisiSchedistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedistInfo>> getActionClassHook() {
		return StdSchedistSelect.class;
	}
	
	
	
	@Override protected List<SchedistInfo> mergeHook(List<SchedistInfo> recordInfos, List<SchedistInfo> selectedInfos) {	
		return SchedistMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
