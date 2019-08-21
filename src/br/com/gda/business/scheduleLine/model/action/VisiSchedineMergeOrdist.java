package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.orderList.model.decisionTree.RootOrdistSelect;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.info.SchedineMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedineMergeOrdist extends ActionVisitorTemplateMergeV2<SchedineInfo, OrdistInfo> {
	
	public VisiSchedineMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return RootOrdistSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<OrdistInfo> selectedInfos) {	
		return SchedineMerger.mergeWithOrdist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
