package br.com.mind5.payment.refundOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.PayormarchRootSelect;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.info.RefuMerger;

public final class RefuVisiMergePayormarch extends ActionVisitorTemplateMerge<RefuInfo, PayormarchInfo> {
	
	public RefuVisiMergePayormarch(DeciTreeOption<RefuInfo> option) {
		super(option, PayormarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return PayormarchRootSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return PayormarchCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> mergeHook(List<RefuInfo> baseInfos, List<PayormarchInfo> selectedInfos) {	
		return RefuMerger.mergeWithPayormarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
