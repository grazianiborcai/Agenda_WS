package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree.RootEmplarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplateMergeEmplarch extends ActionVisitorTemplateMergeV1<EmplateInfo, EmplarchInfo> {
	
	public VisiEmplateMergeEmplarch(Connection conn, String schemaName) {
		super(conn, schemaName, EmplarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplarchInfo>> getTreeClassHook() {
		return RootEmplarchSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> recordInfos, List<EmplarchInfo> selectedInfos) {	
		return EmplateMerger.mergeWithEmplarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
