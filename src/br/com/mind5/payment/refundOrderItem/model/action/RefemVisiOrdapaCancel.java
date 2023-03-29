package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree.OrdapaRootCancel;

public final class RefemVisiOrdapaCancel extends ActionVisitorTemplateAction<RefemInfo, OrdapaInfo> {
	
	public RefemVisiOrdapaCancel(DeciTreeOption<RefemInfo> option) {
		super(option, RefemInfo.class, OrdapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdapaInfo>> getTreeClassHook() {
		return OrdapaRootCancel.class;
	}
	
	
	
	@Override protected List<RefemInfo> toBaseClassHook(List<RefemInfo> baseInfos, List<OrdapaInfo> results) {	
		return RefemMerger.mergeWithOrdapa(baseInfos, results);
	}
}
