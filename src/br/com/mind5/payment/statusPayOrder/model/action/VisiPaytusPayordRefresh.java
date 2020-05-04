package br.com.mind5.payment.statusPayOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.model.decisionTree.RootPayordRefresh;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusMerger;

final class VisiPaytusPayordRefresh extends ActionVisitorTemplateActionV2<PaytusInfo, PayordInfo> {
	
	public VisiPaytusPayordRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option, PaytusInfo.class, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordInfo>> getTreeClassHook() {
		return RootPayordRefresh.class;
	}
	
	
	
	@Override protected List<PaytusInfo> toBaseClassHook(List<PaytusInfo> baseInfos, List<PayordInfo> results) {
		return PaytusMerger.mergeWithPayord(baseInfos, results);
	}
}
