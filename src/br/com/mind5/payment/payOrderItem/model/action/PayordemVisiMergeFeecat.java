package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.decisionTree.RootFeecatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

public final class PayordemVisiMergeFeecat extends ActionVisitorTemplateMerge<PayordemInfo, FeecatInfo> {
	
	public PayordemVisiMergeFeecat(DeciTreeOption<PayordemInfo> option) {
		super(option, FeecatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeecatInfo>> getTreeClassHook() {
		return RootFeecatSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<FeecatInfo> selectedInfos) {	
		return PayordemMerger.mergeWithFeecat(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
