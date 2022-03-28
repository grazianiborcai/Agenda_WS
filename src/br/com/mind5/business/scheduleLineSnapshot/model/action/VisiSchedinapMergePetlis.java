package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.model.decisionTree.PetlisRootSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedinapMergePetlis extends ActionVisitorTemplateMerge<SchedinapInfo, PetlisInfo> {
	
	public VisiSchedinapMergePetlis(DeciTreeOption<SchedinapInfo> option) {
		super(option, PetlisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetlisInfo>> getTreeClassHook() {
		return PetlisRootSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> baseInfos, List<PetlisInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithPetlis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
