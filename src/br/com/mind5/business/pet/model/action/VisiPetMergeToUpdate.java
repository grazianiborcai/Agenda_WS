package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetMergeToUpdate extends ActionVisitorTemplateMerge<PetInfo, PetInfo> {
	
	public VisiPetMergeToUpdate(DeciTreeOption<PetInfo> option) {
		super(option, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PetInfo>> getActionClassHook() {
		return StdPetDaoSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> toActionClassHook(List<PetInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetInfo> selectedInfos) {	
		return PetMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
