package br.com.mind5.config.payPartnerStoreCreation.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.model.decisionTree.PayrsocreNodeSelectEnabled;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrsocreVisiNodeSelectEnabled extends ActionVisitorTemplateAction<PayrsocreInfo, PayrsocreInfo> {

	public PayrsocreVisiNodeSelectEnabled(DeciTreeOption<PayrsocreInfo> option) {
		super(option, PayrsocreInfo.class, PayrsocreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayrsocreInfo>> getTreeClassHook() {
		return PayrsocreNodeSelectEnabled.class;
	}
	
	
	
	@Override protected List<PayrsocreInfo> toBaseClassHook(List<PayrsocreInfo> baseInfos, List<PayrsocreInfo> results) {
		return results;
	}
}
