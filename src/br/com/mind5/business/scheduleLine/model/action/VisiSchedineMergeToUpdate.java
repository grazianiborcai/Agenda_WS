package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiSchedineMergeToUpdate extends ActionVisitorTemplateMerge<SchedineInfo, SchedineInfo> {
	
	public VisiSchedineMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SchedineInfo>> getActionClassHook() {
		return StdSchedineSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<SchedineInfo> selectedInfos) {	
		return SchedineMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
