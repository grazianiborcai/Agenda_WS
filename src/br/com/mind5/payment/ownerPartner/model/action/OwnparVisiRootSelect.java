package br.com.mind5.payment.ownerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.decisionTree.OwnparRootSelect;

public final class OwnparVisiRootSelect extends ActionVisitorTemplateAction<OwnparInfo, OwnparInfo> {

	public OwnparVisiRootSelect(DeciTreeOption<OwnparInfo> option) {
		super(option, OwnparInfo.class, OwnparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnparInfo>> getTreeClassHook() {
		return OwnparRootSelect.class;
	}
	
	
	
	@Override protected List<OwnparInfo> toBaseClassHook(List<OwnparInfo> baseInfos, List<OwnparInfo> results) {
		return results;
	}
}
