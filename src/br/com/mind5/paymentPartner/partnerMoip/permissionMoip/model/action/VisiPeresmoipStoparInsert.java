package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparCopier;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.StoparRootInsert;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

final class VisiPeresmoipStoparInsert extends ActionVisitorTemplateAction<PeresmoipInfo, StoparInfo> {
	
	public VisiPeresmoipStoparInsert(DeciTreeOption<PeresmoipInfo> option) {
		super(option, PeresmoipInfo.class, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return StoparRootInsert.class;
	}
	
	
	
	@Override protected List<StoparInfo> toActionClassHook(List<PeresmoipInfo> baseInfos) {
		return StoparCopier.copyFromPeresmoip(baseInfos);
	}
	
	
	
	@Override protected List<PeresmoipInfo> toBaseClassHook(List<PeresmoipInfo> baseInfos, List<StoparInfo> results) {
		return baseInfos;
	}
}
