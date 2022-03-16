package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.RootPayparSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

public final class StoparVisiMergePaypar extends ActionVisitorTemplateMerge<StoparInfo, PayparInfo> {
	
	public StoparVisiMergePaypar(DeciTreeOption<StoparInfo> option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> baseInfos, List<PayparInfo> selectedInfos) {	
		return StoparMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
