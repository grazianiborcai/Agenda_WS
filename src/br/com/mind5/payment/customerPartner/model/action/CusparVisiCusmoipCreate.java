package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree.RootCusmoipCreate;


public final class CusparVisiCusmoipCreate extends ActionVisitorTemplateAction<CusparInfo, CusmoipInfo> {
	
	public CusparVisiCusmoipCreate(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class, CusmoipInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusmoipInfo>> getTreeClassHook() {
		return RootCusmoipCreate.class;
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CusmoipInfo> results) {
		return CusparMerger.mergeWithCusmoip(baseInfos, results);
	}
}
