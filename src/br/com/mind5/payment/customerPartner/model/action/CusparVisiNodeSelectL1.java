package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparNodeSelectL1;

public final class CusparVisiNodeSelectL1 extends ActionVisitorTemplateAction<CusparInfo, CusparInfo> {

	public CusparVisiNodeSelectL1(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparNodeSelectL1.class;
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CusparInfo> results) {
		return results;
	}
}
