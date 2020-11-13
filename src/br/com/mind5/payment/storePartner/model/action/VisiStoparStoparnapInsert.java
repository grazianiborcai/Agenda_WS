package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.decisionTree.RootStoparnapInsert;

final class VisiStoparStoparnapInsert extends ActionVisitorTemplateAction<StoparInfo, StoparnapInfo> {

	public VisiStoparStoparnapInsert(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparnapInfo>> getTreeClassHook() {
		return RootStoparnapInsert.class;
	}
	
	
	
	@Override protected List<StoparInfo> toBaseClassHook(List<StoparInfo> baseInfos, List<StoparnapInfo> results) {
		return StoparMerger.mergeWithStoparnap(baseInfos, results);
	}
}
