package br.com.mind5.business.personBioSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.business.personBioSnapshot.info.PerbionapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbionapMergeToSelect extends ActionVisitorTemplateMerge<PerbionapInfo, PerbionapInfo> {
	
	public VisiPerbionapMergeToSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option, PerbionapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PerbionapInfo>> getActionClassHook() {
		return StdPerbionapDaoSelect.class;
	}
	
	
	
	@Override protected List<PerbionapInfo> toActionClassHook(List<PerbionapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<PerbionapInfo> mergeHook(List<PerbionapInfo> baseInfos, List<PerbionapInfo> selectedInfos) {	
		return PerbionapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
