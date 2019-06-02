package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.model.decisionTree.RootEmpnapInsert;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpInsertEmpnap extends ActionVisitorTemplateMergeV2<EmpInfo, EmpnapInfo> {
	
	public VisiEmpInsertEmpnap(Connection conn, String schemaName) {
		super(conn, schemaName, EmpnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpnapInfo>> getTreeClassHook() {
		return RootEmpnapInsert.class;
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> recordInfos, List<EmpnapInfo> selectedInfos) {	
		return EmpMerger.mergeWithEmpnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
