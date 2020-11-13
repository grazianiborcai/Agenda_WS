package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.info.SotarchMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSotarchMergeToSelect extends ActionVisitorTemplateMerge<SotarchInfo, SotarchInfo> {
	
	public VisiSotarchMergeToSelect(DeciTreeOption<SotarchInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SotarchInfo>> getActionClassHook() {
		return StdSotarchDaoSelect.class;
	}
	
	
	
	@Override protected List<SotarchInfo> mergeHook(List<SotarchInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return SotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
