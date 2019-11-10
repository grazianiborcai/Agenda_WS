package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpwotarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwotarchInfo, EmpwotarchInfo> {
	
	public VisiEmpwotarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwotarchInfo>> getActionClassHook() {
		return StdEmpwotarchSelect.class;
	}
	
	
	
	@Override protected List<EmpwotarchInfo> mergeHook(List<EmpwotarchInfo> recordInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
