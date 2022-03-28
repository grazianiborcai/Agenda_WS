package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.PetarchRootSelectUser;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiRootSelectUser extends ActionVisitorTemplateAction<PetarchInfo, PetarchInfo> {

	public PetarchVisiRootSelectUser(DeciTreeOption<PetarchInfo> option) {
		super(option, PetarchInfo.class, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetarchInfo>> getTreeClassHook() {
		return PetarchRootSelectUser.class;
	}
	
	
	
	@Override protected List<PetarchInfo> toBaseClassHook(List<PetarchInfo> baseInfos, List<PetarchInfo> results) {
		return results;
	}
}
