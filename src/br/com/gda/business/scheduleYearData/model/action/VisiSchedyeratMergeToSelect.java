package br.com.gda.business.scheduleYearData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.scheduleYearData.info.SchedyeratMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedyeratMergeToSelect extends ActionVisitorTemplateMergeV2<SchedyeratInfo, SchedyeratInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
