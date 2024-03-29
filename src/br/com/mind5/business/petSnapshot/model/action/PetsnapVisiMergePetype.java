package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.info.PetsnapMerger;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.decisionTree.PetypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetsnapVisiMergePetype extends ActionVisitorTemplateMerge<PetsnapInfo, PetypeInfo> {
	
	public PetsnapVisiMergePetype(DeciTreeOption<PetsnapInfo> option) {
		super(option, PetypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetypeInfo>> getTreeClassHook() {
		return PetypeRootSelect.class;
	}
	
	
	
	@Override protected List<PetsnapInfo> mergeHook(List<PetsnapInfo> baseInfos, List<PetypeInfo> selectedInfos) {	
		return PetsnapMerger.mergeWithPetype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
