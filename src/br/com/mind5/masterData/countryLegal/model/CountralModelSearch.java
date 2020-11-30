package br.com.mind5.masterData.countryLegal.model;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.model.decisionTree.RootCountralSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountralModelSearch extends ModelTemplate<CountralInfo> {

	public CountralModelSearch(CountralInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CountralInfo> getDecisionTreeHook(DeciTreeOption<CountralInfo> option) {
		return new RootCountralSearch(option);
	}
}
