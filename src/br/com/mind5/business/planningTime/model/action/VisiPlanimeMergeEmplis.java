package br.com.mind5.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisCopier;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanimeMergeEmplis extends ActionVisitorTemplateMergeV2<PlanimeInfo, EmplisInfo> {
	
	public VisiPlanimeMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return EmplisCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithEmplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
