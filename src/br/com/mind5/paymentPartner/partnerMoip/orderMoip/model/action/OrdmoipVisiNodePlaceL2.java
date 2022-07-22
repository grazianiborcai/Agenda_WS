package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree.OrdmoipNodePlaceL2;

public final class OrdmoipVisiNodePlaceL2 extends ActionVisitorTemplateAction<OrdmoipInfo, OrdmoipInfo> {

	public OrdmoipVisiNodePlaceL2(DeciTreeOption<OrdmoipInfo> option) {
		super(option, OrdmoipInfo.class, OrdmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdmoipInfo>> getTreeClassHook() {
		return OrdmoipNodePlaceL2.class;
	}
	
	
	
	@Override protected List<OrdmoipInfo> toBaseClassHook(List<OrdmoipInfo> baseInfos, List<OrdmoipInfo> results) {
		return results;
	}
}
