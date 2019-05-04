package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;

final class VisiEmpMergeToSelect extends ActionVisitorTemplateMerge_<EmpInfo, EmpInfo> {
	
	public VisiEmpMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpInfo>> getActionClassHook() {
		return StdEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> recordInfos, List<EmpInfo> selectedInfos) {	
		return EmpMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}
