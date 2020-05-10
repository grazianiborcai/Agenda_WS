package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.decisionTree.RootFeecatSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

final class VisiPayordemMergeFeecat extends ActionVisitorTemplateMergeV2<PayordemInfo, FeecatInfo> {
	
	public VisiPayordemMergeFeecat(DeciTreeOption<PayordemInfo> option) {
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
