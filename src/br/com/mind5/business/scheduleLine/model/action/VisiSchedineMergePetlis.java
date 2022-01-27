package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.model.decisionTree.RootPetlisSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineMergePetlis extends ActionVisitorTemplateMerge<SchedineInfo, PetlisInfo> {
	
	public VisiSchedineMergePetlis(DeciTreeOption<SchedineInfo> option) {
		super(option, PetlisInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetlisInfo>> getTreeClassHook() {
		return RootPetlisSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> baseInfos, List<PetlisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithPetlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
