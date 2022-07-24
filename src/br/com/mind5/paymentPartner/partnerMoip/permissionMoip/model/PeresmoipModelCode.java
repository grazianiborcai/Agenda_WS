package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.PeresmoipRootCode;


public final class PeresmoipModelCode extends ModelTemplate<PeresmoipInfo> {
	public PeresmoipModelCode(PeresmoipInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PeresmoipInfo> getDecisionTreeHook(DeciTreeOption<PeresmoipInfo> option) {
		return new PeresmoipRootCode(option);
	}
}
