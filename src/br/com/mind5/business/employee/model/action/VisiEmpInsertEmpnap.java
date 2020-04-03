package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.model.decisionTree.RootEmpnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpInsertEmpnap extends ActionVisitorTemplateMergeV1<EmpInfo, EmpnapInfo> {
	
	public VisiEmpInsertEmpnap(Connection conn, String schemaName) {
		super(conn, schemaName, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpnapInfo>> getTreeClassHook() {
		return RootEmpnapInsert.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<EmpnapInfo> selectedInfos) {	
		return EmpMerger.mergeWithEmpnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
