package br.com.gda.payment.partnerMoip.accessMoip.model;

import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.partnerMoip.accessMoip.model.decisionTree.RootAccemoipUrl;


public final class AccemoipModelUrl extends ModelTemplate<AccemoipInfo> {

	public AccemoipModelUrl(AccemoipInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<AccemoipInfo> getDecisionTreeHook(DeciTreeOption<AccemoipInfo> option) {
		return new RootAccemoipUrl(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
