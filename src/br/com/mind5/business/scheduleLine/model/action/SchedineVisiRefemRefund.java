package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.model.decisionTree.RefemRootRefundAuth;

public final class SchedineVisiRefemRefund extends ActionVisitorTemplateAction<SchedineInfo, RefemInfo> {

	public SchedineVisiRefemRefund(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, RefemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefemInfo>> getTreeClassHook() {
		return RefemRootRefundAuth.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<RefemInfo> results) {
		return baseInfos;
	}
}
