package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.decisionTree.PeresmoipRootInsert;

public final class AccemoipVisiPeresmoipInsert extends ActionVisitorTemplateAction<AccemoipInfo, PeresmoipInfo> {
	
	public AccemoipVisiPeresmoipInsert(DeciTreeOption<AccemoipInfo> option) {
		super(option, AccemoipInfo.class, PeresmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeresmoipInfo>> getTreeClassHook() {
		return PeresmoipRootInsert.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> toBaseClassHook(List<AccemoipInfo> baseInfos, List<PeresmoipInfo> results) {
		return baseInfos;
	}
}
