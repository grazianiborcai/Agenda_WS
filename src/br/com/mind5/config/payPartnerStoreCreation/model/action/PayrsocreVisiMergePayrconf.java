package br.com.mind5.config.payPartnerStoreCreation.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.decisionTree.PayrconfRootSelect;
import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrsocreVisiMergePayrconf extends ActionVisitorTemplateMerge<PayrsocreInfo, PayrconfInfo> {
	
	public PayrsocreVisiMergePayrconf(DeciTreeOption<PayrsocreInfo> option) {
		super(option, PayrconfInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayrconfInfo>> getTreeClassHook() {
		return PayrconfRootSelect.class;
	}
	
	
	
	@Override protected List<PayrsocreInfo> mergeHook(List<PayrsocreInfo> baseInfos, List<PayrconfInfo> selectedInfos) {	
		return PayrsocreMerger.mergeWithPayrconf(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
