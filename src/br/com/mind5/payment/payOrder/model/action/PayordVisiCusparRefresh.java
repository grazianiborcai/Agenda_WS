package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootRefreshOnEmpty;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordVisiCusparRefresh extends ActionVisitorTemplateAction<PayordInfo, CusparInfo> {
	
	public PayordVisiCusparRefresh(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootRefreshOnEmpty.class;
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<CusparInfo> results) {
		return baseInfos;
	}
}
