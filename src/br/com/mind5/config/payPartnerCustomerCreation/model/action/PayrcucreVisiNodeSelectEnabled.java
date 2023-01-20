package br.com.mind5.config.payPartnerCustomerCreation.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.decisionTree.PayrcucreNodeSelectEnabled;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrcucreVisiNodeSelectEnabled extends ActionVisitorTemplateAction<PayrcucreInfo, PayrcucreInfo> {

	public PayrcucreVisiNodeSelectEnabled(DeciTreeOption<PayrcucreInfo> option) {
		super(option, PayrcucreInfo.class, PayrcucreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayrcucreInfo>> getTreeClassHook() {
		return PayrcucreNodeSelectEnabled.class;
	}
	
	
	
	@Override protected List<PayrcucreInfo> toBaseClassHook(List<PayrcucreInfo> baseInfos, List<PayrcucreInfo> results) {
		return results;
	}
}
