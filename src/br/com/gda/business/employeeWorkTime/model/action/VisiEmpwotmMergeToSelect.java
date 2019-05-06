package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiEmpwotmMergeToSelect extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwotmInfo> {
	
	public VisiEmpwotmMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpwotmInfo>> getActionClassHook() {
		return StdEmpwotmSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> recordInfos, List<EmpwotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
