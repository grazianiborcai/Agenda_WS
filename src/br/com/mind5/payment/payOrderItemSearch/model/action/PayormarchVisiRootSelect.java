package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.decisionTree.PayormarchRootSelect;

public final class PayormarchVisiRootSelect extends ActionVisitorTemplateAction<PayormarchInfo, PayormarchInfo> {

	public PayormarchVisiRootSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option, PayormarchInfo.class, PayormarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayormarchInfo>> getTreeClassHook() {
		return PayormarchRootSelect.class;
	}
	
	
	
	@Override protected List<PayormarchInfo> toBaseClassHook(List<PayormarchInfo> baseInfos, List<PayormarchInfo> results) {
		return results;
	}
}
