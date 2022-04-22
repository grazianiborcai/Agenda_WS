package br.com.mind5.business.phoneSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonarchVisiRootSelect extends ActionVisitorTemplateAction<PhonarchInfo, PhonarchInfo> {

	public PhonarchVisiRootSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option, PhonarchInfo.class, PhonarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonarchInfo>> getTreeClassHook() {
		return PhonarchRootSelect.class;
	}
	
	
	
	@Override protected List<PhonarchInfo> toBaseClassHook(List<PhonarchInfo> baseInfos, List<PhonarchInfo> results) {
		return results;
	}
}
