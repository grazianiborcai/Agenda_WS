package br.com.mind5.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.business.employeeMaterial.model.decisionTree.RootEmpmatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpmatMergeToDelete extends ActionVisitorTemplateMerge<EmpmatInfo, EmpmatInfo> {
	
	public VisiEmpmatMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, EmpmatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmatInfo>> getTreeClassHook() {
		return RootEmpmatSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpmatInfo> selectedInfos) {	
		return EmpmatMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
