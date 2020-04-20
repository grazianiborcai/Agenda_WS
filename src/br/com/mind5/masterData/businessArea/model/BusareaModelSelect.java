package br.com.mind5.masterData.businessArea.model;

import br.com.mind5.masterData.businessArea.info.BusareaInfo;
import br.com.mind5.masterData.businessArea.model.decisionTree.RootBusareaSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusareaModelSelect extends ModelTemplate<BusareaInfo> {

	public BusareaModelSelect(BusareaInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BusareaInfo> getDecisionTreeHook(DeciTreeOption<BusareaInfo> option) {
		return new RootBusareaSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
