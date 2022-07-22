package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.OrdmoipNodeStoparL1;

public final class OrdmoipVisiNodeStoparL1 extends ActionVisitorTemplateAction<OrdmoipInfo, OrdmoipInfo> {

	public OrdmoipVisiNodeStoparL1(DeciTreeOption<OrdmoipInfo> option) {
		super(option, OrdmoipInfo.class, OrdmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdmoipInfo>> getTreeClassHook() {
		return OrdmoipNodeStoparL1.class;
	}
	
	
	
	@Override protected List<OrdmoipInfo> toBaseClassHook(List<OrdmoipInfo> baseInfos, List<OrdmoipInfo> results) {
		return results;
	}
}
