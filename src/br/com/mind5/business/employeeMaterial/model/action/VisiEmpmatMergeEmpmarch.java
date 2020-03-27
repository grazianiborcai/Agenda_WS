package br.com.mind5.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatMerger;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.RootEmpmarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpmatMergeEmpmarch extends ActionVisitorTemplateMerge<EmpmatInfo, EmpmarchInfo> {
	
	public VisiEmpmatMergeEmpmarch(Connection conn, String schemaName) {
		super(conn, schemaName, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmarchInfo>> getTreeClassHook() {
		return RootEmpmarchSelect.class;
	}
	
	
	
	@Override protected List<EmpmatInfo> mergeHook(List<EmpmatInfo> recordInfos, List<EmpmarchInfo> selectedInfos) {	
		return EmpmatMerger.mergeWithEmpmarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
