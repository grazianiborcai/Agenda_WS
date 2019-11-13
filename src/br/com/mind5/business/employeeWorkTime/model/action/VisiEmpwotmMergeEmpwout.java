package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeEmpwout extends ActionVisitorTemplateMergeV2<EmpwotmInfo, EmpwoutInfo> {
	
	public VisiEmpwotmMergeEmpwout(Connection conn, String schemaName) {
		super(conn, schemaName, EmpwoutInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwoutInfo>> getTreeClassHook() {
		return RootEmpwoutSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> recordInfos, List<EmpwoutInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithEmpwout(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
