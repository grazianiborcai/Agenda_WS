package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.decisionTree.RootPaytusemSelect;

final class VisiPaytusMergePaytusem extends ActionVisitorTemplateMergeV2<PaytusInfo, PaytusemInfo> {
	
	public VisiPaytusMergePaytusem(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusemInfo>> getTreeClassHook() {
		return RootPaytusemSelect.class;
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> baseInfos, List<PaytusemInfo> selectedInfos) {	
		return PaytusMerger.mergeWithPaytusem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
