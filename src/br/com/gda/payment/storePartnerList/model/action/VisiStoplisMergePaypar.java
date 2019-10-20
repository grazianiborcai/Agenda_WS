package br.com.gda.payment.storePartnerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;
import br.com.gda.payment.storePartnerList.info.StoplisMerger;

final class VisiStoplisMergePaypar extends ActionVisitorTemplateMergeV2<StoplisInfo, PayparInfo> {
	
	public VisiStoplisMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> recordInfos, List<PayparInfo> selectedInfos) {	
		return StoplisMerger.mergeWithPaypar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
