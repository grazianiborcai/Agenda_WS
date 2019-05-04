package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeToDelete extends ActionVisitorTemplateMerge_<EmpwotmInfo, EmpwotmInfo> {
	
	public VisiEmpwotmMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return RootEmpwotmSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwotmInfo>> getMergerClassHook() {
		return EmpwotmMerger.class;
	}
}
