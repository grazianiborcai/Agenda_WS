package br.com.gda.business.planningTime_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.planningTime_.info.PlanInfo;
import br.com.gda.business.planningTime_.info.PlanMerger;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPlanMergeStowotm extends ActionVisitorTemplateMerge_<PlanInfo, StowotmInfo> {
	
	public VisiPlanMergeStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return RootStowotmSelect.class;
	}
	
	
	
	@Override protected List<PlanInfo> mergeHook(List<PlanInfo> recordInfos, List<StowotmInfo> selectedInfos) {	
		return PlanMerger.mergeWithStowotm(selectedInfos, recordInfos);
	}
}
