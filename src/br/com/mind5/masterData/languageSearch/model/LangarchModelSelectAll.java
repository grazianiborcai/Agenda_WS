package br.com.mind5.masterData.languageSearch.model;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.decisionTree.LangarchRootSelectAll;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchModelSelectAll extends ModelTemplate<LangarchInfo> {

	public LangarchModelSelectAll(LangarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<LangarchInfo> getDecisionTreeHook(DeciTreeOption<LangarchInfo> option) {
		return new LangarchRootSelectAll(option);
	}
}
