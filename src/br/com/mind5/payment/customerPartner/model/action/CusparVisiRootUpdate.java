package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootUpdate;

public final class CusparVisiRootUpdate extends ActionVisitorTemplateAction<CusparInfo, CusparInfo> {

	public CusparVisiRootUpdate(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootUpdate.class;
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CusparInfo> results) {
		return results;
	}
}
