package br.com.mind5.business.ownerSearch.model;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.decisionTree.RootOwnarchSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnarchModelSelect extends ModelTemplate<OwnarchInfo> {

	public OwnarchModelSelect(OwnarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<OwnarchInfo> getDecisionTreeHook(DeciTreeOption<OwnarchInfo> option) {
		return new RootOwnarchSelect(option);
	}
}
