package br.com.gda.business.scheduleRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleRange.info.SchedageInfo;
import br.com.gda.business.scheduleRange.info.SchedageMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedageMergeToSelect extends ActionVisitorTemplateMergeV2<SchedageInfo, SchedageInfo> {
	
	public VisiSchedageMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedageInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedageInfo>> getActionClassHook() {
		return StdSchedageSelect.class;
	}
	
	
	
	@Override protected List<SchedageInfo> mergeHook(List<SchedageInfo> recordInfos, List<SchedageInfo> selectedInfos) {	
		return SchedageMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
