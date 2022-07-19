package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.CusparchRootSelect;

public final class CusparchVisiRootSelect extends ActionVisitorTemplateAction<CusparchInfo, CusparchInfo> {

	public CusparchVisiRootSelect(DeciTreeOption<CusparchInfo> option) {
		super(option, CusparchInfo.class, CusparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparchInfo>> getTreeClassHook() {
		return CusparchRootSelect.class;
	}
	
	
	
	@Override protected List<CusparchInfo> toBaseClassHook(List<CusparchInfo> baseInfos, List<CusparchInfo> results) {
		return results;
	}
}
