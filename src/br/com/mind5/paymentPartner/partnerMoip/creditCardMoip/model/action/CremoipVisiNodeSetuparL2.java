package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.CremoipNodeSetuparL2;

public final class CremoipVisiNodeSetuparL2 extends ActionVisitorTemplateAction<CremoipInfo, CremoipInfo> {

	public CremoipVisiNodeSetuparL2(DeciTreeOption<CremoipInfo> option) {
		super(option, CremoipInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CremoipInfo>> getTreeClassHook() {
		return CremoipNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<CremoipInfo> toBaseClassHook(List<CremoipInfo> baseInfos, List<CremoipInfo> results) {
		return results;
	}
}
