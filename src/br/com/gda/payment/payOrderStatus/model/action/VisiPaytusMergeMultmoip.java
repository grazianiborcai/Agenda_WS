package br.com.gda.payment.payOrderStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree.RootMultmoipRead;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;
import br.com.gda.payment.payOrderStatus.info.PaytusMerger;

final class VisiPaytusMergeMultmoip extends ActionVisitorTemplateMergeV2<PaytusInfo, MultmoipInfo> {
	
	public VisiPaytusMergeMultmoip(Connection conn, String schemaName) {
		super(conn, schemaName, MultmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MultmoipInfo>> getTreeClassHook() {
		return RootMultmoipRead.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<MultmoipInfo> selectedInfos) {	
		return PaytusMerger.mergeWithMultmoip(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
