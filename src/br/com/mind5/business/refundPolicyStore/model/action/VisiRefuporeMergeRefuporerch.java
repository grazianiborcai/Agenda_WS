package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree.RootRefuporerchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeMergeRefuporerch extends ActionVisitorTemplateMergeV2<RefuporeInfo, RefuporerchInfo> {
	
	public VisiRefuporeMergeRefuporerch(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporerchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporerchInfo>> getTreeClassHook() {
		return RootRefuporerchSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefuporerchInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefuporerch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
