package br.com.mind5.business.ownerSearch.model.action;

import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.info.OwnarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnarchMergeToSelect extends ActionVisitorTemplateMerge<OwnarchInfo, OwnarchInfo> {
	
	public VisiOwnarchMergeToSelect(DeciTreeOption<OwnarchInfo> option) {
		super(option, OwnarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwnarchInfo>> getActionClassHook() {
		return StdOwnarchDaoSelect.class;
	}
	
	
	
	@Override protected List<OwnarchInfo> mergeHook(List<OwnarchInfo> baseInfos, List<OwnarchInfo> selectedInfos) {	
		return OwnarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
