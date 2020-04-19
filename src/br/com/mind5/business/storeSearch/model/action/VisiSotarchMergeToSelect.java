package br.com.mind5.business.storeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.info.SotarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSotarchMergeToSelect extends ActionVisitorTemplateMergeV2<SotarchInfo, SotarchInfo> {
	
	public VisiSotarchMergeToSelect(DeciTreeOption<SotarchInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<SotarchInfo>> getActionClassHook() {
		return StdSotarchDaoSelect.class;
	}
	
	
	
	@Override protected List<SotarchInfo> mergeHook(List<SotarchInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return SotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
