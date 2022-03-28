package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.model.decisionTree.PetsnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiPetsnapInsert extends ActionVisitorTemplateAction<PetInfo, PetsnapInfo> {

	public PetVisiPetsnapInsert(DeciTreeOption<PetInfo> option) {
		super(option, PetInfo.class, PetsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetsnapInfo>> getTreeClassHook() {
		return PetsnapRootInsert.class;
	}
	
	
	
	protected List<PetInfo> toBaseClassHook(List<PetInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		return PetMerger.mergeWithPetsnap(baseInfos, selectedInfos);
	}
}
