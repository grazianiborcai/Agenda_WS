package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.PayordemistRootSelect;

public final class PayordemistVisiRootSelect extends ActionVisitorTemplateAction<PayordemistInfo, PayordemistInfo> {

	public PayordemistVisiRootSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option, PayordemistInfo.class, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemistInfo>> getTreeClassHook() {
		return PayordemistRootSelect.class;
	}
	
	
	
	@Override protected List<PayordemistInfo> toBaseClassHook(List<PayordemistInfo> baseInfos, List<PayordemistInfo> results) {
		return results;
	}
}
