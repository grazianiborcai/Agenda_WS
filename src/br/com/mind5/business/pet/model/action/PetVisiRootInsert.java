package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.PetRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiRootInsert extends ActionVisitorTemplateAction<PetInfo, PetInfo> {

	public PetVisiRootInsert(DeciTreeOption<PetInfo> option) {
		super(option, PetInfo.class, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetInfo>> getTreeClassHook() {
		return PetRootInsert.class;
	}
	
	
	
	@Override protected List<PetInfo> toBaseClassHook(List<PetInfo> baseInfos, List<PetInfo> results) {
		return results;
	}
}
