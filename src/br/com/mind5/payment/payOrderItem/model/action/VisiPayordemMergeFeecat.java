package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.decisionTree.RootFeecatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

final class VisiPayordemMergeFeecat extends ActionVisitorTemplateMergeV1<PayordemInfo, FeecatInfo> {
	
	public VisiPayordemMergeFeecat(Connection conn, String schemaName) {
		super(conn, schemaName, FeecatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeecatInfo>> getTreeClassHook() {
		return RootFeecatSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<FeecatInfo> selectedInfos) {	
		return PayordemMerger.mergeWithFeecat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
