package br.com.mind5.masterData.moonPhase.model;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.MoonaseRootSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseModelSearch extends ModelTemplate<MoonaseInfo> {

	public MoonaseModelSearch(MoonaseInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<MoonaseInfo> getDecisionTreeHook(DeciTreeOption<MoonaseInfo> option) {
		return new MoonaseRootSearch(option);
	}
}
