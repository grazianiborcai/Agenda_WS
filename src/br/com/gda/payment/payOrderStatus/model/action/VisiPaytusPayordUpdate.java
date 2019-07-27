package br.com.gda.payment.payOrderStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.model.decisionTree.RootPayordUpdate;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;
import br.com.gda.payment.payOrderStatus.info.PaytusMerger;

final class VisiPaytusPayordUpdate extends ActionVisitorTemplateMergeV2<PaytusInfo, PayordInfo> {
	
	public VisiPaytusPayordUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordUpdate.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<PayordInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPayord(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
