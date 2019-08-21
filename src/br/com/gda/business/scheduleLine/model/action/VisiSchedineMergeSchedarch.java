package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.business.scheduleSearch.model.decisionTree.RootSchedarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedineMergeSchedarch extends ActionVisitorTemplateMergeV2<SchedineInfo, SchedarchInfo> {
	
	public VisiSchedineMergeSchedarch(Connection conn, String schemaName) {
		super(conn, schemaName, SchedarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedarchInfo>> getTreeClassHook() {
		return RootSchedarchSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<SchedarchInfo> selectedInfos) {	
		return SchedineInfo.copyFrom(selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
