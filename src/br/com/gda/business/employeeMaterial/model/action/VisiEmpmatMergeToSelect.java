package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMerge;

final class VisiEmpmatMergeToSelect extends ActionVisitorTemplateMerge<EmpmatInfo, EmpmatInfo> {
	
	public VisiEmpmatMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmpmatInfo>> getActionClassHook() {
		return StdEmpmatSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpmatInfo> selectedInfos) {	
		return EmpmatMerger.mergeToSelect(selectedInfos, recordInfos);
	}
}
