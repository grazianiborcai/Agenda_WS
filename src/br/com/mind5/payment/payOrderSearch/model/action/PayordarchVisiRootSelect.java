package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.decisionTree.PayordarchRootSelect;

public final class PayordarchVisiRootSelect extends ActionVisitorTemplateAction<PayordarchInfo, PayordarchInfo> {

	public PayordarchVisiRootSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option, PayordarchInfo.class, PayordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordarchInfo>> getTreeClassHook() {
		return PayordarchRootSelect.class;
	}
	
	
	
	@Override protected List<PayordarchInfo> toBaseClassHook(List<PayordarchInfo> baseInfos, List<PayordarchInfo> results) {
		return results;
	}
}
