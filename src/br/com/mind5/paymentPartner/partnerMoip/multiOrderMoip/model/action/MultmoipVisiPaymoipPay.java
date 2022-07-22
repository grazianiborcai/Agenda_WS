package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipCopier;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree.RootPaymoipPay;

public final class MultmoipVisiPaymoipPay extends ActionVisitorTemplateAction<MultmoipInfo, PaymoipInfo> {

	public MultmoipVisiPaymoipPay(DeciTreeOption<MultmoipInfo> option) {
		super(option, MultmoipInfo.class, PaymoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PaymoipInfo>> getTreeClassHook() {
		return RootPaymoipPay.class;
	}
	
	
	
	@Override protected List<PaymoipInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return PaymoipCopier.copyFromMultmoip(baseInfos);
	}
	
	
	
	@Override protected List<MultmoipInfo> toBaseClassHook(List<MultmoipInfo> baseInfos, List<PaymoipInfo> results) {
		return MultmoipMerger.mergeWithPaymoip(baseInfos, results);
	}
}
