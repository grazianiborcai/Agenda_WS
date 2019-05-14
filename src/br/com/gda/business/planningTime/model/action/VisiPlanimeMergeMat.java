package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatCopier;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.info.PlanimeMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanimeMergeMat extends ActionVisitorTemplateMergeV2<PlanimeInfo, MatInfo> {
	
	public VisiPlanimeMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return MatCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
