package br.com.gda.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleYear.info.SchedyearInfo;
import br.com.gda.business.scheduleYear.info.SchedyearMerger;
import br.com.gda.business.scheduleYearData.info.SchedyeratCopier;
import br.com.gda.business.scheduleYearData.info.SchedyeratInfo;
import br.com.gda.business.scheduleYearData.model.decisionTree.RootSchedyeratSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedyearMergeSchedyerat extends ActionVisitorTemplateMergeV2<SchedyearInfo, SchedyeratInfo> {
	
	public VisiSchedyearMergeSchedyerat(Connection conn, String schemaName) {
		super(conn, schemaName, SchedyeratInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedyeratInfo>> getTreeClassHook() {
		return RootSchedyeratSelect.class;
	}
	
	
	
	@Override protected List<SchedyeratInfo> toActionClassHook(List<SchedyearInfo> recordInfos) {
		return SchedyeratCopier.copyFromSchedyear(recordInfos);
	}
	
	
	
	@Override protected List<SchedyearInfo> mergeHook(List<SchedyearInfo> recordInfos, List<SchedyeratInfo> selectedInfos) {	
		return SchedyearMerger.mergeWithSchedyerat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
