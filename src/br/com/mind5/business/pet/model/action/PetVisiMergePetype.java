package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.decisionTree.PetypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergePetype extends ActionVisitorTemplateMerge<PetInfo, PetypeInfo> {
	
	public PetVisiMergePetype(DeciTreeOption<PetInfo> option) {
		super(option, PetypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetypeInfo>> getTreeClassHook() {
		return PetypeRootSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetypeInfo> selectedInfos) {	
		return PetMerger.mergeWithPetype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
