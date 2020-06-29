package br.com.mind5.business.personSearch.model.action;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchMergeToSelect extends ActionVisitorTemplateMergeV2<PerarchInfo, PerarchInfo> {
	
	public VisiPerarchMergeToSelect(DeciTreeOption<PerarchInfo> option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PerarchInfo>> getActionClassHook() {
		return StdPerarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PerarchInfo> mergeHook(List<PerarchInfo> baseInfos, List<PerarchInfo> selectedInfos) {	
		return PerarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
