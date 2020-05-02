package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootFeeCategSelect;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeFeeCateg extends ActionVisitorTemplateMergeV2<OrderInfo, FeeCategInfo> {
	
	public VisiOrderMergeFeeCateg(DeciTreeOption<OrderInfo> option) { 
		super(option, FeeCategInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeCategInfo>> getTreeClassHook() {
		return RootFeeCategSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<FeeCategInfo> selectedInfos) {	
		return OrderMerger.mergeWithFeeCateg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
