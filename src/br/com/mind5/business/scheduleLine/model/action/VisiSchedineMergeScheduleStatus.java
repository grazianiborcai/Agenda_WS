package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootScheduleStatusSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedineMergeScheduleStatus extends ActionVisitorTemplateMerge<SchedineInfo, ScheduleStatusInfo> {
	
	public VisiSchedineMergeScheduleStatus(Connection conn, String schemaName) {
		super(conn, schemaName, ScheduleStatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<ScheduleStatusInfo>> getTreeClassHook() {
		return RootScheduleStatusSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<ScheduleStatusInfo> selectedInfos) {	
		return SchedineMerger.mergeWithScheduleStatus(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
