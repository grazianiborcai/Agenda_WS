package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.PetarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergePetarch extends ActionVisitorTemplateMerge<PetInfo, PetarchInfo> {
	
	public PetVisiMergePetarch(DeciTreeOption<PetInfo> option) {
		super(option, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetarchInfo>> getTreeClassHook() {
		return PetarchRootSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetarchInfo> selectedInfos) {	
		return PetMerger.mergeWithPetarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
