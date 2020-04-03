package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiSchedineMergeToMove extends ActionVisitorTemplateMergeV1<SchedineInfo, SchedineInfo> {
	
	public VisiSchedineMergeToMove(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<SchedineInfo>> getActionClassHook() {
		return StdSchedineSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToMove(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
