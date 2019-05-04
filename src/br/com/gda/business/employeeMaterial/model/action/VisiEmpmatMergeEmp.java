package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpmatMergeEmp extends ActionVisitorTemplateMerge<EmpmatInfo, EmpInfo> {
	
	public VisiEmpmatMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return RootEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpInfo> selectedInfos) {	
		return EmpmatMerger.mergeWithEmp(selectedInfos, recordInfos);
	}
}
