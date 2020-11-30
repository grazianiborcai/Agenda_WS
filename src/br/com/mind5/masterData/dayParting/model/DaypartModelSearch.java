package br.com.mind5.masterData.dayParting.model;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.decisionTree.RootDaypartSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DaypartModelSearch extends ModelTemplate<DaypartInfo> {

	public DaypartModelSearch(DaypartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<DaypartInfo> getDecisionTreeHook(DeciTreeOption<DaypartInfo> option) {
		return new RootDaypartSearch(option);
	}
}
