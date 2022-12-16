package br.com.mind5.config.payPartnerConfig.model.action;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.decisionTree.PayrconfNodeSelectStoparEnabled;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayrconfVisiNodeSelectStoparEnabled extends ActionVisitorTemplateAction<PayrconfInfo, PayrconfInfo> {

	public PayrconfVisiNodeSelectStoparEnabled(DeciTreeOption<PayrconfInfo> option) {
		super(option, PayrconfInfo.class, PayrconfInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayrconfInfo>> getTreeClassHook() {
		return PayrconfNodeSelectStoparEnabled.class;
	}
	
	
	
	@Override protected List<PayrconfInfo> toBaseClassHook(List<PayrconfInfo> baseInfos, List<PayrconfInfo> results) {
		return results;
	}
}
