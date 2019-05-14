package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpCopier;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpSelect;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.info.PlanimeMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanimeMergeEmp extends ActionVisitorTemplateMergeV2<PlanimeInfo, EmpInfo> {
	
	public VisiPlanimeMergeEmp(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpInfo>> getTreeClassHook() {
		return RootEmpSelect.class;
	}
	
	
	
	@Override protected List<EmpInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return EmpCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<EmpInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithEmp(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
