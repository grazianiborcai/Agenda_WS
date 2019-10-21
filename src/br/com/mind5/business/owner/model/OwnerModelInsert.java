package br.com.mind5.business.owner.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.decisionTree.RootOwnerInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OwnerModelInsert extends ModelTemplate<OwnerInfo> {

	public OwnerModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OwnerInfo.class);
	}
	
	
	
	@Override protected DeciTree<OwnerInfo> getDecisionTreeHook(DeciTreeOption<OwnerInfo> option) {
		return new RootOwnerInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
