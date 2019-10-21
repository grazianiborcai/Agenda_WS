package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplevateMergeToDelete extends ActionVisitorTemplateMergeV2<EmplevateInfo, EmplevateInfo> {
	
	public VisiEmplevateMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmplevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplevateInfo>> getTreeClassHook() {
		return RootEmplevateSelect.class;
	}
	
	
	
	@Override protected List<EmplevateInfo> mergeHook(List<EmplevateInfo> recordInfos, List<EmplevateInfo> selectedInfos) {	
		return EmplevateMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
