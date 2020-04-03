package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiEmpwotarchMergeToSelect extends ActionVisitorTemplateMergeV1<EmpwotarchInfo, EmpwotarchInfo> {
	
	public VisiEmpwotarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<EmpwotarchInfo>> getActionClassHook() {
		return StdEmpwotarchSelect.class;
	}
	
	
	
	@Override protected List<EmpwotarchInfo> mergeHook(List<EmpwotarchInfo> recordInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
