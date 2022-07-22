package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.decisionTree.StoparnapRootSelect;

public final class StoparnapVisiRootSelect extends ActionVisitorTemplateAction<StoparnapInfo, StoparnapInfo> {

	public StoparnapVisiRootSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option, StoparnapInfo.class, StoparnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparnapInfo>> getTreeClassHook() {
		return StoparnapRootSelect.class;
	}
	
	
	
	@Override protected List<StoparnapInfo> toBaseClassHook(List<StoparnapInfo> baseInfos, List<StoparnapInfo> results) {
		return results;
	}
}
