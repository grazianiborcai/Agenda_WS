package br.com.mind5.business.personBioSearch.model.action;

import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.info.PerbiorchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbiorchMergeToSelect extends ActionVisitorTemplateMerge<PerbiorchInfo, PerbiorchInfo> {
	
	public VisiPerbiorchMergeToSelect(DeciTreeOption<PerbiorchInfo> option) {
		super(option, PerbiorchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PerbiorchInfo>> getActionClassHook() {
		return StdPerbiorchDaoSelect.class;
	}
	
	
	
	@Override protected List<PerbiorchInfo> mergeHook(List<PerbiorchInfo> baseInfos, List<PerbiorchInfo> selectedInfos) {	
		return PerbiorchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
