package br.com.mind5.payment.statusPayOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.RootPayordSelect;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;

final class VisiPaytusMergePayord extends ActionVisitorTemplateMergeV2<PaytusInfo, PayordInfo> {
	
	public VisiPaytusMergePayord(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordSelect.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> baseInfos, List<PayordInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPayord(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
