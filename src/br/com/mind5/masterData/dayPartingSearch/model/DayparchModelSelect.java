package br.com.mind5.masterData.dayPartingSearch.model;

import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.masterData.dayPartingSearch.model.decisionTree.RootDayparchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DayparchModelSelect extends ModelTemplate<DayparchInfo> {

	public DayparchModelSelect(DayparchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<DayparchInfo> getDecisionTreeHook(DeciTreeOption<DayparchInfo> option) {
		return new RootDayparchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
