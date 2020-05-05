package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree.RootCremoipAdd;


final class VisiCrecardAddCremoip extends ActionVisitorTemplateActionV2<CrecardInfo, CremoipInfo> {
	
	public VisiCrecardAddCremoip(DeciTreeOption<CrecardInfo> option) {
		super(option, CrecardInfo.class, CremoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CremoipInfo>> getTreeClassHook() {
		return RootCremoipAdd.class;
	}
	
	
	
	@Override protected List<CremoipInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return CremoipCopier.copyFromCrecard(baseInfos);
	}
	
	
	
	@Override protected List<CrecardInfo> toBaseClassHook(List<CrecardInfo> baseInfos, List<CremoipInfo> selectedInfos) {
		return CrecardMerger.mergeWithCremoip(baseInfos, selectedInfos);
	}
}
