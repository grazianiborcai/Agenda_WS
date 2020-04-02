package br.com.mind5.business.employeeWorkTimeRange.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiEmpworgMergeToSelect extends ActionVisitorTemplateMerge<EmpworgInfo, EmpworgInfo> {
	
	public VisiEmpworgMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpworgInfo>> getActionClassHook() {
		return StdEmpworgSelect.class;
	}
	
	
	
	@Override protected List<EmpworgInfo> mergeHook(List<EmpworgInfo> recordInfos, List<EmpworgInfo> selectedInfos) {	
		return EmpworgMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
