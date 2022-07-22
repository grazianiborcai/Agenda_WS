package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree.MultmoipNodePlace;

public final class MultmoipVisiNodePlace extends ActionVisitorTemplateAction<MultmoipInfo, MultmoipInfo> {

	public MultmoipVisiNodePlace(DeciTreeOption<MultmoipInfo> option) {
		super(option, MultmoipInfo.class, MultmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MultmoipInfo>> getTreeClassHook() {
		return MultmoipNodePlace.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<MultmoipInfo> results) {
		return results;
	}
}
