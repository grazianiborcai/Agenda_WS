package br.com.mind5.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmplevateMergeToSelect extends ActionVisitorTemplateMergeV2<EmplevateInfo, EmplevateInfo> {
	
	public VisiEmplevateMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplevateInfo>> getActionClassHook() {
		return StdEmplevateSelect.class;
	}
	
	
	
	@Override protected List<EmplevateInfo> mergeHook(List<EmplevateInfo> recordInfos, List<EmplevateInfo> selectedInfos) {	
		return EmplevateMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
