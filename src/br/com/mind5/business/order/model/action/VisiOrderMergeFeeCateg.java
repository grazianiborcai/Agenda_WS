package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootFeeCategSelect;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrderMergeFeeCateg extends ActionVisitorTemplateMergeV2<OrderInfo, FeeCategInfo> {
	
	public VisiOrderMergeFeeCateg(Connection conn, String schemaName) {
		super(conn, schemaName, FeeCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeCategInfo>> getTreeClassHook() {
		return RootFeeCategSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> recordInfos, List<FeeCategInfo> selectedInfos) {	
		return OrderMerger.mergeWithFeeCateg(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
