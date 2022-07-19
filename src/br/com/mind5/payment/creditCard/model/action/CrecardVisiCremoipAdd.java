package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.CremoipRootAdd;


public final class CrecardVisiCremoipAdd extends ActionVisitorTemplateAction<CrecardInfo, CremoipInfo> {
	
	public CrecardVisiCremoipAdd(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CremoipInfo>> getTreeClassHook() {
		return CremoipRootAdd.class;
	}
	
	
	
	@Override protected List<CremoipInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CremoipCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CremoipInfo> selectedInfos) {
		return CrecardMerger.mergeWithCremoip(baseInfos, selectedInfos);
	}
}
