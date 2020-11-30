package br.com.mind5.business.storeNearby.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.RootStorbySelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyModelSelect extends ModelTemplate<StorbyInfo> {

	public StorbyModelSelect(String incomingData, HttpServletRequest request) {
		super(incomingData, request, StorbyInfo.class);
	}
	
	
	
	@Override protected DeciTree<StorbyInfo> getDecisionTreeHook(DeciTreeOption<StorbyInfo> option) {
		return new RootStorbySelect(option);
	}
}
