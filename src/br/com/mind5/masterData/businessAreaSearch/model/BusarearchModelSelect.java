package br.com.mind5.masterData.businessAreaSearch.model;

import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;
import br.com.mind5.masterData.businessAreaSearch.model.decisionTree.BusarearchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BusarearchModelSelect extends ModelTemplate<BusarearchInfo> {

	public BusarearchModelSelect(BusarearchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BusarearchInfo> getDecisionTreeHook(DeciTreeOption<BusarearchInfo> option) {
		return new BusarearchRootSelect(option);
	}
}
