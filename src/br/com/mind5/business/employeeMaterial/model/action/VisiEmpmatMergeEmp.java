package br.com.mind5.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.RootEmpSelect;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpmatMergeEmp extends ActionVisitorTemplateMergeV2<EmpmatInfo, EmpInfo> {
	
	public VisiEmpmatMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return RootEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpInfo> selectedInfos) {	
		return EmpmatMerger.mergeWithEmp(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
