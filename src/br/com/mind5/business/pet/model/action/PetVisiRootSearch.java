package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.PetRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiRootSearch extends ActionVisitorTemplateAction<PetInfo, PetInfo> {

	public PetVisiRootSearch(DeciTreeOption<PetInfo> option) {
		super(option, PetInfo.class, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetInfo>> getTreeClassHook() {
		return PetRootSearch.class;
	}
	
	
	
	@Override protected List<PetInfo> toBaseClassHook(List<PetInfo> baseInfos, List<PetInfo> results) {
		return results;
	}
}
