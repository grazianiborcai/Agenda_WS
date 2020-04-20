package br.com.mind5.masterData.areaPhoneSearch.model;

import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.masterData.areaPhoneSearch.model.decisionTree.RootAreanarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AreanarchModelSelect extends ModelTemplate<AreanarchInfo> {

	public AreanarchModelSelect(AreanarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<AreanarchInfo> getDecisionTreeHook(DeciTreeOption<AreanarchInfo> option) {
		return new RootAreanarchSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
