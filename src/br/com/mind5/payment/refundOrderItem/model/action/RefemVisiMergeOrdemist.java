package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.OrdemistRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;

public final class RefemVisiMergeOrdemist extends ActionVisitorTemplateMerge<RefemInfo, OrdemistInfo> {
	
	public RefemVisiMergeOrdemist(DeciTreeOption<RefemInfo> option) {
		super(option, OrdemistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return OrdemistRootSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		return RefemMerger.mergeWithOrdemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
