package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.PetarchRootSelectCus;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiRootSelectCus extends ActionVisitorTemplateAction<PetarchInfo, PetarchInfo> {

	public PetarchVisiRootSelectCus(DeciTreeOption<PetarchInfo> option) {
		super(option, PetarchInfo.class, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PetarchInfo>> getTreeClassHook() {
		return PetarchRootSelectCus.class;
	}
	
	
	
	@Override protected List<PetarchInfo> toBaseClassHook(List<PetarchInfo> baseInfos, List<PetarchInfo> results) {
		return results;
	}
}
