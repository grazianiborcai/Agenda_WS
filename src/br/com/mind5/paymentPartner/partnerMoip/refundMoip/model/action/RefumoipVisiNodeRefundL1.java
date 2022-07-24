package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree.RefumoipNodeRefundL1;

public final class RefumoipVisiNodeRefundL1 extends ActionVisitorTemplateAction<RefumoipInfo, RefumoipInfo> {

	public RefumoipVisiNodeRefundL1(DeciTreeOption<RefumoipInfo> option) {
		super(option, RefumoipInfo.class, RefumoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefumoipInfo>> getTreeClassHook() {
		return RefumoipNodeRefundL1.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> toBaseClassHook(List<RefumoipInfo> baseInfos, List<RefumoipInfo> results) {
		return results;
	}
}
