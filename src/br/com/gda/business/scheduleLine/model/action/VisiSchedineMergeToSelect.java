package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.info.SchedineMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiSchedineMergeToSelect extends ActionVisitorTemplateMergeV2<SchedineInfo, SchedineInfo> {
	
	public VisiSchedineMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedineInfo>> getActionClassHook() {
		return StdSchedineSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
