package br.com.mind5.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonMerger;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatCopier;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.model.decisionTree.RootSchedonthatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedmonMergeSchedonthat extends ActionVisitorTemplateMergeV1<SchedmonInfo, SchedonthatInfo> {
	
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
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
