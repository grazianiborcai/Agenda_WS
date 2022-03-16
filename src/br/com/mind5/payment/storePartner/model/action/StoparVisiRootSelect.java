package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.StoparRootSelect;

public final class StoparVisiRootSelect extends ActionVisitorTemplateAction<StoparInfo, StoparInfo> {

	public StoparVisiRootSelect(DeciTreeOption<StoparInfo> option) {
		super(option, StoparInfo.class, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return StoparRootSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> toBaseClassHook(List<StoparInfo> baseInfos, List<StoparInfo> results) {
		return results;
	}
}
