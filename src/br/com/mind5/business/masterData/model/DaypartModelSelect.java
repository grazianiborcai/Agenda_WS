package br.com.mind5.business.masterData.model;

import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootDaypartSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DaypartModelSelect extends ModelTemplate<DaypartInfo> {

	public DaypartModelSelect(DaypartInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<DaypartInfo> getDecisionTreeHook(DeciTreeOption<DaypartInfo> option) {
		return new RootDaypartSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
