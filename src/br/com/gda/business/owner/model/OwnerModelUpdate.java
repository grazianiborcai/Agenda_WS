package br.com.gda.business.owner.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.decisionTree.RootOwnerUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwnerModelUpdate extends ModelTemplate<OwnerInfo> {

	public OwnerModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, OwnerInfo.class);
	}
	
	
	
	@Override protected DeciTree<OwnerInfo> getDecisionTreeHook(DeciTreeOption<OwnerInfo> option) {
		return new RootOwnerUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
