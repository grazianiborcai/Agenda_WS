package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipInsert;

final class VisiAccemoipPeresmoipInsert extends ActionVisitorTemplateActionV2<AccemoipInfo, PeresmoipInfo> {
	
	public VisiAccemoipPeresmoipInsert(DeciTreeOption<AccemoipInfo> option) {
		super(option, AccemoipInfo.class, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeresmoipInfo>> getTreeClassHook() {
		return RootPeresmoipInsert.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> toBaseClassHook(List<AccemoipInfo> baseInfos, List<PeresmoipInfo> results) {
		return baseInfos;
	}
}
