package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeEmpwoco extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwocoInfo> {
	
	public VisiEmpwotmMergeEmpwoco(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwocoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwocoInfo>> getTreeClassHook() {
		return RootEmpwocoSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> recordInfos, List<EmpwocoInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwoco(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
