package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaCopier;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree.OrdapaRootRead;

public final class PayordVisiOrdapaRead extends ActionVisitorTemplateAction<PayordInfo, OrdapaInfo> {
	
	public PayordVisiOrdapaRead(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, OrdapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdapaInfo>> getTreeClassHook() {
		return OrdapaRootRead.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return OrdapaCopier.copyFromPayord(recordInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<OrdapaInfo> selectedInfos) {
		return PayordMerger.mergeWithOrdapa(baseInfos, selectedInfos);
	}
}
