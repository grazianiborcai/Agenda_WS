package br.com.mind5.business.planingData.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.info.PlanataMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPlanataMergeMat extends ActionVisitorTemplateMergeV2<PlanataInfo, MatInfo> {
	
	public VisiPlanataMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<PlanataInfo> mergeHook(List<PlanataInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return PlanataMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
