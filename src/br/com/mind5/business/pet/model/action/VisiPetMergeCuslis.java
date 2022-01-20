package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetMergeCuslis extends ActionVisitorTemplateMerge<PetInfo, CuslisInfo> {
	
	public VisiPetMergeCuslis(DeciTreeOption<PetInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return PetMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
