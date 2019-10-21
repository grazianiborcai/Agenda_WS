package br.com.mind5.business.scheduleMonthData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedonthatMergeToSelect extends ActionVisitorTemplateMergeV2<SchedonthatInfo, SchedonthatInfo> {
	
	public VisiSchedonthatMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedonthatInfo>> getActionClassHook() {
		return StdSchedonthatSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> mergeHook(List<SchedonthatInfo> recordInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedonthatMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
