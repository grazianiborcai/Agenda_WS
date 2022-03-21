package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.PetRootSearchUser;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiMergePet extends ActionVisitorTemplateMerge<CusInfo, PetInfo> {
	
	public CusVisiMergePet(DeciTreeOption<CusInfo> option) {
		super(option, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetInfo>> getTreeClassHook() {
		return PetRootSearchUser.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<PetInfo> selectedInfos) {	
		return CusMerger.mergeWithPet(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
