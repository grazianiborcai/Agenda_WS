package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.model.decisionTree.PetaultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergePetault extends ActionVisitorTemplateMerge<PetInfo, PetaultInfo> {
	
	public PetVisiMergePetault(DeciTreeOption<PetInfo> option) {
		super(option, PetaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetaultInfo>> getTreeClassHook() {
		return PetaultRootSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetaultInfo> selectedInfos) {	
		return PetMerger.mergeWithPetault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
