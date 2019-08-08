package br.com.gda.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.model.decisionTree.RootPaymoipRead;
import br.com.gda.payment.statusPayOrder.info.PaytusInfo;
import br.com.gda.payment.statusPayOrder.info.PaytusMerger;

final class VisiPaytusMergePaymoip extends ActionVisitorTemplateMergeV2<PaytusInfo, PaymoipInfo> {
	
	public VisiPaytusMergePaymoip(Connection conn, String schemaName) {
		super(conn, schemaName, PaymoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaymoipInfo>> getTreeClassHook() {
		return RootPaymoipRead.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<PaymoipInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPaymoip(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
