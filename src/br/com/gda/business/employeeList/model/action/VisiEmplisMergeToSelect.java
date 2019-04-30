package br.com.gda.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.info.EmplisMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge;

final class VisiEmplisMergeToSelect extends ActionVisitorTemplateMerge<EmplisInfo, EmplisInfo> {
	
	public VisiEmplisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplisInfo>> getActionClassHook() {
		return StdEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return EmplisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}
