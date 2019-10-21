package br.com.mind5.payment.partnerMoip.accessMoip.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.payment.partnerMoip.accessMoip.model.decisionTree.RootAccemoipUrl;


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
