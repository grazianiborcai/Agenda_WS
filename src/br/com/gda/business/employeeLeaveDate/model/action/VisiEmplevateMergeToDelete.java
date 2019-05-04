package br.com.gda.business.employeeLeaveDate.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmplevateMergeToDelete extends ActionVisitorTemplateMerge_<EmplevateInfo, EmplevateInfo> {
	
	public VisiEmplevateMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmplevateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplevateInfo>> getTreeClassHook() {
		return RootEmplevateSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmplevateInfo>> getMergerClassHook() {
		return EmplevateMerger.class;
	}
}
