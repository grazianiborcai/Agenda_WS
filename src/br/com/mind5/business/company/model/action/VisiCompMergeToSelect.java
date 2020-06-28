package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompMergeToSelect extends ActionVisitorTemplateMergeV2<CompInfo, CompInfo> {
	
	public VisiCompMergeToSelect(DeciTreeOption<CompInfo> option) {
		super(option, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CompInfo>> getActionClassHook() {
		return StdCompDaoSelect.class;
	}
	
	
	
	@Override protected List<CompInfo> mergeHook(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {	
		return CompMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
