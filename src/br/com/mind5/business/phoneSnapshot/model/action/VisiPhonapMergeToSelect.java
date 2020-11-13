package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonapMergeToSelect extends ActionVisitorTemplateMerge<PhonapInfo, PhonapInfo> {
	
	public VisiPhonapMergeToSelect(DeciTreeOption<PhonapInfo> option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PhonapInfo>> getActionClassHook() {
		return StdPhonapDaoSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return PhonapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
