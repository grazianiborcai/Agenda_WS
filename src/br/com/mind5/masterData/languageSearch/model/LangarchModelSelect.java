package br.com.mind5.masterData.languageSearch.model;

import br.com.mind5.masterData.languageSearch.info.LangarchInfo;
import br.com.mind5.masterData.languageSearch.model.decisionTree.RootLangarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LangarchModelSelect extends ModelTemplate<LangarchInfo> {

	public LangarchModelSelect(LangarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<LangarchInfo> getDecisionTreeHook(DeciTreeOption<LangarchInfo> option) {
		return new RootLangarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
