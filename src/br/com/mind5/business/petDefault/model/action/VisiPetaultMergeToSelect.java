package br.com.mind5.business.petDefault.model.action;

import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.info.PetaultMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetaultMergeToSelect extends ActionVisitorTemplateMerge<PetaultInfo, PetaultInfo> {
	
	public VisiPetaultMergeToSelect(DeciTreeOption<PetaultInfo> option) {
		super(option, PetaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PetaultInfo>> getActionClassHook() {
		return StdPetaultDaoSelect.class;
	}
	
	
	
	@Override protected List<PetaultInfo> mergeHook(List<PetaultInfo> baseInfos, List<PetaultInfo> selectedInfos) {	
		return PetaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
