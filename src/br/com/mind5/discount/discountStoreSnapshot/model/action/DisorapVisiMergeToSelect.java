package br.com.mind5.discount.discountStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorapVisiMergeToSelect extends ActionVisitorTemplateMerge<DisorapInfo, DisorapInfo> {
	
	public DisorapVisiMergeToSelect(DeciTreeOption<DisorapInfo> option) {
		super(option, DisorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<DisorapInfo>> getVisitorClassHook() {
		return DisorapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<DisorapInfo> mergeHook(List<DisorapInfo> baseInfos, List<DisorapInfo> selectedInfos) {	
		return DisorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
