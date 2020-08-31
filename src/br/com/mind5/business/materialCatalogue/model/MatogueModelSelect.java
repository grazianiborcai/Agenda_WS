package br.com.mind5.business.materialCatalogue.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.materialCatalogue.model.decisionTree.RootMatogueSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatogueModelSelect extends ModelTemplate<MatogueInfo> {

	public MatogueModelSelect(String incomingData, HttpServletRequest request) {
		super(incomingData, request, MatogueInfo.class);
	}
	
	
	
	@Override protected DeciTree<MatogueInfo> getDecisionTreeHook(DeciTreeOption<MatogueInfo> option) {
		return new RootMatogueSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
