package br.com.mind5.business.scheduleYear.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearMerger;
import br.com.mind5.business.scheduleYearData.info.SchedyeratCopier;
import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.business.scheduleYearData.model.decisionTree.RootSchedyeratSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedyearMergeSchedyerat extends ActionVisitorTemplateMerge<SchedyearInfo, SchedyeratInfo> {
	
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
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
