package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.RootPetarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetMergePetarch extends ActionVisitorTemplateMerge<PetInfo, PetarchInfo> {
	
	public VisiPetMergePetarch(DeciTreeOption<PetInfo> option) {
		super(option, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetarchInfo>> getTreeClassHook() {
		return RootPetarchSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetarchInfo> selectedInfos) {	
		return PetMerger.mergeWithPetarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
