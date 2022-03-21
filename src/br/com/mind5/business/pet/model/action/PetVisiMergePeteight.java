package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.masterData.petWeight.model.decisionTree.RootPeteightSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergePeteight extends ActionVisitorTemplateMerge<PetInfo, PeteightInfo> {
	
	public PetVisiMergePeteight(DeciTreeOption<PetInfo> option) {
		super(option, PeteightInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeteightInfo>> getTreeClassHook() {
		return RootPeteightSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PeteightInfo> selectedInfos) {	
		return PetMerger.mergeWithPeteight(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
