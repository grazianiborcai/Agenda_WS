package br.com.mind5.business.scheduleSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedarchMergeToSelect extends ActionVisitorTemplateMergeV2<SchedarchInfo, SchedarchInfo> {
	
	public VisiSchedarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedarchInfo>> getActionClassHook() {
		return StdSchedarchSelect.class;
	}
	
	
	
	@Override protected List<SchedarchInfo> mergeHook(List<SchedarchInfo> recordInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
