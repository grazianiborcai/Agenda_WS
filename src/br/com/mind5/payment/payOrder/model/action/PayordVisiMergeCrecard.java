package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.decisionTree.CrecardRootSelect;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

public final class PayordVisiMergeCrecard extends ActionVisitorTemplateMerge<PayordInfo, CrecardInfo> {
	
	public PayordVisiMergeCrecard(DeciTreeOption<PayordInfo> option) {
		super(option, CrecardInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecardInfo>> getTreeClassHook() {
		return CrecardRootSelect.class;
	}
	
	
	
	@Override protected List<CrecardInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return CrecardCopier.copyFromPayord(baseInfos);	
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<CrecardInfo> selectedInfos) {	
		return PayordMerger.mergeWithCrecard(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
