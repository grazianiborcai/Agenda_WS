package br.com.gda.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatMerger;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpmatMergeMat extends ActionVisitorTemplateMerge<EmpmatInfo, MatInfo> {
	
	public VisiEmpmatMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return EmpmatMerger.mergeWithMat(selectedInfos, recordInfos);
	}
}
