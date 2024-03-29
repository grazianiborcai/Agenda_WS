package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class RefuporarchVisiMergeToSelect extends ActionVisitorTemplateMerge<RefuporarchInfo, RefuporarchInfo> {
	
	public RefuporarchVisiMergeToSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option, RefuporarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<RefuporarchInfo>> getVisitorClassHook() {
		return RefuporarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<RefuporarchInfo> mergeHook(List<RefuporarchInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {	
		return RefuporarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
