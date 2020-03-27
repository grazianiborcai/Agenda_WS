package br.com.mind5.business.scheduleYearData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.info.SchedyeratMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiSchedyeratMergeToSelect extends ActionVisitorTemplateMerge<SchedyeratInfo, SchedyeratInfo> {
	
	public VisiSchedyeratMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedyeratInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedyeratInfo>> getActionClassHook() {
		return StdSchedyeratSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> mergeHook(List<SchedyeratInfo> recordInfos, List<SchedyeratInfo> selectedInfos) {	
		return SchedyeratMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
