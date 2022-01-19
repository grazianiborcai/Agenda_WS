package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.info.PetsnapMerger;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.decisionTree.RootPetypeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetsnapMergePetype extends ActionVisitorTemplateMerge<PetsnapInfo, PetypeInfo> {
	
	public VisiPetsnapMergePetype(DeciTreeOption<PetsnapInfo> option) {
		super(option, PetypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetypeInfo>> getTreeClassHook() {
		return RootPetypeSelect.class;
	}
	
	
	
	@Override protected List<PetsnapInfo> mergeHook(List<PetsnapInfo> baseInfos, List<PetypeInfo> selectedInfos) {	
		return PetsnapMerger.mergeWithPetype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
