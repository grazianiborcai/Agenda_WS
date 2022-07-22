package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree.AccemoipNodeUrl;

public final class AccemoipVisiNodeUrl extends ActionVisitorTemplateAction<AccemoipInfo, AccemoipInfo> {

	public AccemoipVisiNodeUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option, AccemoipInfo.class, AccemoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AccemoipInfo>> getTreeClassHook() {
		return AccemoipNodeUrl.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> toBaseClassHook(List<AccemoipInfo> baseInfos, List<AccemoipInfo> results) {
		return results;
	}
}
