package br.com.mind5.business.storeAccount.model.action;

import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.info.StoracMerger;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.decisionTree.PayparultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoracVisiMergePayparult extends ActionVisitorTemplateMerge<StoracInfo, PayparultInfo> {
	
	public StoracVisiMergePayparult(DeciTreeOption<StoracInfo> option) {
		super(option, PayparultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparultInfo>> getTreeClassHook() {
		return PayparultRootSelect.class;
	}
	
	
	
	@Override protected List<StoracInfo> mergeHook(List<StoracInfo> baseInfos, List<PayparultInfo> selectedInfos) {	
		return StoracMerger.mergeWithPayparult(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
