package br.com.mind5.business.personSearch.model.action;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.PerarchRootSelectAuth;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchVisiRootSelectAuth extends ActionVisitorTemplateAction<PerarchInfo, PerarchInfo> {

	public PerarchVisiRootSelectAuth(DeciTreeOption<PerarchInfo> option) {
		super(option, PerarchInfo.class, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return PerarchRootSelectAuth.class;
	}
	
	
	
	@Override protected List<PerarchInfo> toBaseClassHook(List<PerarchInfo> baseInfos, List<PerarchInfo> results) {
		return results;
	}
}
