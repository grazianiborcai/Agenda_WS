package br.com.mind5.payment.payOrderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootFeeCategSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

final class VisiPayordemMergeFeeCateg extends ActionVisitorTemplateMergeV2<PayordemInfo, FeeCategInfo> {
	
	public VisiPayordemMergeFeeCateg(Connection conn, String schemaName) {
		super(conn, schemaName, FeeCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeCategInfo>> getTreeClassHook() {
		return RootFeeCategSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<FeeCategInfo> selectedInfos) {	
		return PayordemMerger.mergeWithFeeCateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}