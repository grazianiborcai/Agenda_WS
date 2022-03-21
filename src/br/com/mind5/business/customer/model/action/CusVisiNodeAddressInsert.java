package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.CusNodeAddressInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiNodeAddressInsert extends ActionVisitorTemplateAction<CusInfo, CusInfo> {

	public CusVisiNodeAddressInsert(DeciTreeOption<CusInfo> option) {
		super(option, CusInfo.class, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return CusNodeAddressInsert.class;
	}
	
	
	
	@Override protected List<CusInfo> toBaseClassHook(List<CusInfo> baseInfos, List<CusInfo> results) {
		return results;
	}
}
