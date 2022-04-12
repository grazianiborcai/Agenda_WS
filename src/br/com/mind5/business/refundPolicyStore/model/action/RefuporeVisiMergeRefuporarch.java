package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree.RootRefuporarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporeVisiMergeRefuporarch extends ActionVisitorTemplateMerge<RefuporeInfo, RefuporarchInfo> {
	
	public RefuporeVisiMergeRefuporarch(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefuporarchInfo>> getTreeClassHook() {
		return RootRefuporarchSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefuporarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
