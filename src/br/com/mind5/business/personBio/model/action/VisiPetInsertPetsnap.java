package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioMerger;
import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.model.decisionTree.RootPetsnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetInsertPetsnap extends ActionVisitorTemplateAction<PerbioInfo, PetsnapInfo> {

	public VisiPetInsertPetsnap(DeciTreeOption<PerbioInfo> option) {
		super(option, PerbioInfo.class, PetsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetsnapInfo>> getTreeClassHook() {
		return RootPetsnapInsert.class;
	}
	
	
	
	protected List<PerbioInfo> toBaseClassHook(List<PerbioInfo> baseInfos, List<PetsnapInfo> selectedInfos) {
		return PerbioMerger.mergeWithPetsnap(baseInfos, selectedInfos);
	}
}
