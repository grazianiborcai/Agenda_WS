package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.business.employeeMaterial.model.decisionTree.RootEmpmatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpmatMergeToDelete extends ActionVisitorTemplateMerge_<EmpmatInfo, EmpmatInfo> {
	
	public VisiEmpmatMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return RootEmpmatSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpmatInfo> selectedInfos) {	
		return EmpmatMerger.mergeToDelete(selectedInfos, recordInfos);
	}
}
