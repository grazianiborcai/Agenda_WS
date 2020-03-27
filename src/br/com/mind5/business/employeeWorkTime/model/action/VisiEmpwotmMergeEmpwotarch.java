package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.model.decisionTree.RootEmpwotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeEmpwotarch extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwotarchInfo> {
	
	public VisiEmpwotmMergeEmpwotarch(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotarchInfo>> getTreeClassHook() {
		return RootEmpwotarchSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
