package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.PayormarchRootSelect;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemMergePayormarch extends ActionVisitorTemplateMerge<RefemInfo, PayormarchInfo> {
	
	public VisiRefemMergePayormarch(DeciTreeOption<RefemInfo> option) {
		super(option, PayormarchInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return PayormarchRootSelect.class;
	}
	
	
	
	protected List<PayormarchInfo> toActionClassHook(List<RefemInfo> baseInfos) {
		return PayormarchCopier.copyFromRefem(baseInfos);	
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> baseInfos, List<PayormarchInfo> selectedInfos) {
		return RefemMerger.mergeWithPayormarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
