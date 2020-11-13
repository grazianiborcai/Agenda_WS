package br.com.mind5.business.addressSearch.model.action;

import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.info.AddarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddarchMergeToSelect extends ActionVisitorTemplateMerge<AddarchInfo, AddarchInfo> {
	
	public VisiAddarchMergeToSelect(DeciTreeOption<AddarchInfo> option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddarchInfo>> getActionClassHook() {
		return StdAddarchDaoSelect.class;
	}
	
	
	
	@Override protected List<AddarchInfo> mergeHook(List<AddarchInfo> baseInfos, List<AddarchInfo> selectedInfos) {	
		return AddarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
