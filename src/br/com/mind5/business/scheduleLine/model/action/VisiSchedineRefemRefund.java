package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RootRefemRefund;

final class VisiSchedineRefemRefund extends ActionVisitorTemplateActionV2<SchedineInfo, RefemInfo> {

	public VisiSchedineRefemRefund(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, RefemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefemInfo>> getTreeClassHook() {
		return RootRefemRefund.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<RefemInfo> results) {
		return baseInfos;
	}
}
