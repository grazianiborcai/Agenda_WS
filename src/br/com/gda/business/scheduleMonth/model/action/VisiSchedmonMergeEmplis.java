package br.com.gda.business.scheduleMonth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisCopier;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.business.scheduleMonth.info.SchedmonInfo;
import br.com.gda.business.scheduleMonth.info.SchedmonMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedmonMergeEmplis extends ActionVisitorTemplateMergeV2<SchedmonInfo, EmplisInfo> {
	
	public VisiSchedmonMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> toActionClassHook(List<SchedmonInfo> recordInfos) {
		return EmplisCopier.copyFromSchedmon(recordInfos);
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithEmplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
