package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.UsernameRootSelect;

public final class PetVisiMergeUsername extends ActionVisitorTemplateMerge<PetInfo, UsernameInfo> {
	
	public PetVisiMergeUsername(DeciTreeOption<PetInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return UsernameRootSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<PetInfo> baseInfos) {
		return UsernameCopier.copyFromPet(baseInfos);	
	}
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return PetMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
