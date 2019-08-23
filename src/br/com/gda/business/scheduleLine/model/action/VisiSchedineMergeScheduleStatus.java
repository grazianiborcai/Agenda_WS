package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootScheduleStatusSelect;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.info.SchedineMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedineMergeScheduleStatus extends ActionVisitorTemplateMergeV2<SchedineInfo, ScheduleStatusInfo> {
	
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
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
