package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.CrecarchRootSelect;

public final class CrecarchVisiRootSelect extends ActionVisitorTemplateAction<CrecarchInfo, CrecarchInfo> {

	public CrecarchVisiRootSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option, CrecarchInfo.class, CrecarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CrecarchInfo>> getTreeClassHook() {
		return CrecarchRootSelect.class;
	}
	
	
	
	@Override protected List<CrecarchInfo> toBaseClassHook(List<CrecarchInfo> baseInfos, List<CrecarchInfo> results) {
		return results;
	}
}
