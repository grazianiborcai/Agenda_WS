package br.com.mind5.payment.partnerMoip.permissionMoip.model;

import javax.servlet.http.HttpServletRequest;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipCode;


public final class PeresmoipModelCode extends ModelTemplate<PeresmoipInfo> {
	public PeresmoipModelCode(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PeresmoipInfo.class);
	}
	
	
	
	@Override protected DeciTree<PeresmoipInfo> getDecisionTreeHook(DeciTreeOption<PeresmoipInfo> option) {
		return new RootPeresmoipCode(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
