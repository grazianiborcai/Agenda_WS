package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatorarchVisiMergeToSelect extends ActionVisitorTemplateMerge<MatorarchInfo, MatorarchInfo> {
	
	public MatorarchVisiMergeToSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option, MatorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MatorarchInfo>> getVisitorClassHook() {
		return MatorarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MatorarchInfo> mergeHook(List<MatorarchInfo> baseInfos, List<MatorarchInfo> selectedInfos) {	
		return MatorarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
