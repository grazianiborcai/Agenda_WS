package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeEmpwoco extends ActionVisitorTemplateMerge<EmpwotmInfo, EmpwocoInfo> {
	
	public VisiEmpwotmMergeEmpwoco(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwocoInfo>> getTreeClassHook() {
		return RootEmpwocoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwoco(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
