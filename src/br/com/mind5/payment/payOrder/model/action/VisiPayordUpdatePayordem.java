package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemCopier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.RootPayordemUpdate;

final class VisiPayordUpdatePayordem extends ActionVisitorTemplateAction<PayordInfo, PayordemInfo> {
	
	public VisiPayordUpdatePayordem(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return RootPayordemUpdate.class;
	}
	
	
	
	@Override protected List<PayordemInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return PayordemCopier.copyFromPayord(baseInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		return baseInfos;
	}
}
