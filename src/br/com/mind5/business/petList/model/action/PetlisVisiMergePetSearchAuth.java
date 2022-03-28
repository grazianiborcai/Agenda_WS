package br.com.mind5.business.petList.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.PetRootSearchAuth;
import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.info.PetlisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetlisVisiMergePetSearchAuth extends ActionVisitorTemplateMerge<PetlisInfo, PetInfo> {
	
	public PetlisVisiMergePetSearchAuth(DeciTreeOption<PetlisInfo> option) {
		super(option, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetInfo>> getTreeClassHook() {
		return PetRootSearchAuth.class;
	}
	
	
	
	@Override protected List<PetlisInfo> mergeHook(List<PetlisInfo> baseInfos, List<PetInfo> selectedInfos) {	
		return PetlisMerger.mergeWithPetSearch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
