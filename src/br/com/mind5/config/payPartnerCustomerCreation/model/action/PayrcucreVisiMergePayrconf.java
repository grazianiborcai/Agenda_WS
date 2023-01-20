package br.com.mind5.config.payPartnerCustomerCreation.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.decisionTree.PayrconfRootSelect;
import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrcucreVisiMergePayrconf extends ActionVisitorTemplateMerge<PayrcucreInfo, PayrconfInfo> {
	
	public PayrcucreVisiMergePayrconf(DeciTreeOption<PayrcucreInfo> option) {
		super(option, PayrconfInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayrconfInfo>> getTreeClassHook() {
		return PayrconfRootSelect.class;
	}
	
	
	
	@Override protected List<PayrcucreInfo> mergeHook(List<PayrcucreInfo> baseInfos, List<PayrconfInfo> selectedInfos) {	
		return PayrcucreMerger.mergeWithPayrconf(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
