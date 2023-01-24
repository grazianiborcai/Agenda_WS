package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.decisionTree.PayparultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergePayparult extends ActionVisitorTemplateMerge<CrecardInfo, PayparultInfo> {
	
	public CrecardVisiMergePayparult(DeciTreeOption<CrecardInfo> option) {
		super(option, PayparultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparultInfo>> getTreeClassHook() {
		return PayparultRootSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<PayparultInfo> selectedInfos) {	
		return CrecardMerger.mergeWithPayparult(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
