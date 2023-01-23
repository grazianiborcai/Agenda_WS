package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootCreateOnConfigAuth;

public final class CusVisiCusparCreateOnConfig extends ActionVisitorTemplateAction<CusInfo, CusparInfo> {
	
	public CusVisiCusparCreateOnConfig(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootCreateOnConfigAuth.class;
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<CusparInfo> results) {
		return baseInfos;
	}
}
