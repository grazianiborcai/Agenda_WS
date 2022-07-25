package br.com.mind5.payment.setupPartner.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.PayparRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparMerger;

public final class SetuparVisiMergePaypar extends ActionVisitorTemplateMerge<SetuparInfo, PayparInfo> {
	
	public SetuparVisiMergePaypar(DeciTreeOption<SetuparInfo> option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return PayparRootSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> mergeHook(List<SetuparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		return SetuparMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
