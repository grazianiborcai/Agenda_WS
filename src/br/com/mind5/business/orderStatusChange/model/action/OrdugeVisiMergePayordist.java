package br.com.mind5.business.orderStatusChange.model.action;

import java.util.List;

import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.decisionTree.PayordistRootSelect;

public final class OrdugeVisiMergePayordist extends ActionVisitorTemplateMerge<OrdugeInfo, PayordistInfo> {
	
	public OrdugeVisiMergePayordist(DeciTreeOption<OrdugeInfo> option) {
		super(option, PayordistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordistInfo>> getTreeClassHook() {
		return PayordistRootSelect.class;
	}
	
	
	
	@Override protected List<OrdugeInfo> mergeHook(List<OrdugeInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return OrdugeMerger.mergeWithPayordist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
