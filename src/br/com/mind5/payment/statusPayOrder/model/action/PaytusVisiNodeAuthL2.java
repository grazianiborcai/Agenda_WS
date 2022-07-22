package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.decisionTree.PaytusNodeAuthL2;

public final class PaytusVisiNodeAuthL2 extends ActionVisitorTemplateAction<PaytusInfo, PaytusInfo> {

	public PaytusVisiNodeAuthL2(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PaytusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaytusInfo>> getTreeClassHook() {
		return PaytusNodeAuthL2.class;
	}
	
	
	
	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PaytusInfo> results) {
		return results;
	}
}
