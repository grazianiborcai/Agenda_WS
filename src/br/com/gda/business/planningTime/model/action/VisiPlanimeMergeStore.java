package br.com.gda.business.planningTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planningTime.info.PlanimeInfo;
import br.com.gda.business.planningTime.info.PlanimeMerger;
import br.com.gda.business.store.info.StoreCopier;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanimeMergeStore extends ActionVisitorTemplateMergeV2<PlanimeInfo, StoreInfo> {
	
	public VisiPlanimeMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return RootStoreSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return StoreCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> recordInfos, List<StoreInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithStore(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
