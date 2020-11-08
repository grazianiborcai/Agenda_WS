package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.info.PayordemistMerger;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.RootPayormarchSelect;

final class VisiPayordemistMergePayormarch extends ActionVisitorTemplateMergeV2<PayordemistInfo, PayormarchInfo> {
	
	public VisiPayordemistMergePayormarch(DeciTreeOption<PayordemistInfo> option) {
		super(option, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return RootPayormarchSelect.class;
	}
	
	
	
	@Override protected List<PayordemistInfo> mergeHook(List<PayordemistInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return PayordemistMerger.mergeWithPayormarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
