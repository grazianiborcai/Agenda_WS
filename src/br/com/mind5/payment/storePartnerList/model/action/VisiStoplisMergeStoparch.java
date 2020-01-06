package br.com.mind5.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.RootStoparchSelect;

final class VisiStoplisMergeStoparch extends ActionVisitorTemplateMergeV2<StoplisInfo, StoparchInfo> {
	
	public VisiStoplisMergeStoparch(Connection conn, String schemaName) {
		super(conn, schemaName, StoparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparchInfo>> getTreeClassHook() {
		return RootStoparchSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> recordInfos, List<StoparchInfo> selectedInfos) {	
		return StoplisMerger.mergeWithStoparch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
