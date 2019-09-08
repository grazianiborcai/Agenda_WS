package br.com.gda.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonMerger;
import br.com.gda.business.scheduleMonthData.info.SchedonthatCopier;
import br.com.gda.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.gda.business.scheduleMonthData.model.decisionTree.RootSchedonthatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedmonMergeSchedonthat extends ActionVisitorTemplateMergeV2<SchedmonInfo, SchedonthatInfo> {
	
	public VisiSchedmonMergeSchedonthat(Connection conn, String schemaName) {
		super(conn, schemaName, SchedonthatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedonthatInfo>> getTreeClassHook() {
		return RootSchedonthatSelect.class;
	}
	
	
	
	@Override protected List<SchedonthatInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return SchedonthatCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> recordInfos, List<SchedonthatInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithSchedonthat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
