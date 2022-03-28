package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.model.decisionTree.PetlisRootSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiMergePetlis extends ActionVisitorTemplateMerge<SchedineInfo, PetlisInfo> {
	
	public SchedineVisiMergePetlis(DeciTreeOption<SchedineInfo> option) {
		super(option, PetlisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetlisInfo>> getTreeClassHook() {
		return PetlisRootSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<PetlisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithPetlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
