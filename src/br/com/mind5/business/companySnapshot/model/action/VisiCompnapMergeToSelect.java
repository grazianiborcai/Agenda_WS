package br.com.mind5.business.companySnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.business.companySnapshot.info.CompnapMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompnapMergeToSelect extends ActionVisitorTemplateMergeV2<CompnapInfo, CompnapInfo> {
	
	public VisiCompnapMergeToSelect(DeciTreeOption<CompnapInfo> option) {
		super(option, CompnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CompnapInfo>> getActionClassHook() {
		return StdCompnapDaoSelect.class;
	}
	
	
	
	@Override protected List<CompnapInfo> mergeHook(List<CompnapInfo> baseInfos, List<CompnapInfo> selectedInfos) {	
		return CompnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
