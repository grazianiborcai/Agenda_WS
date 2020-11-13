package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorarchMergeToSelect extends ActionVisitorTemplateMerge<MatorarchInfo, MatorarchInfo> {
	
	public VisiMatorarchMergeToSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option, MatorarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MatorarchInfo>> getActionClassHook() {
		return StdMatorarchDaoSelect.class;
	}
	
	
	
	@Override protected List<MatorarchInfo> mergeHook(List<MatorarchInfo> baseInfos, List<MatorarchInfo> selectedInfos) {	
		return MatorarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
