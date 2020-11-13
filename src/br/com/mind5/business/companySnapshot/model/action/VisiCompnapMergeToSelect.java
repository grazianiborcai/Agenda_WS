package br.com.mind5.business.companySnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.info.CompnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompnapMergeToSelect extends ActionVisitorTemplateMerge<CompnapInfo, CompnapInfo> {
	
	public VisiCompnapMergeToSelect(DeciTreeOption<CompnapInfo> option) {
		super(option, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CompnapInfo>> getActionClassHook() {
		return StdCompnapDaoSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> mergeHook(List<CompnapInfo> baseInfos, List<CompnapInfo> selectedInfos) {	
		return CompnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
