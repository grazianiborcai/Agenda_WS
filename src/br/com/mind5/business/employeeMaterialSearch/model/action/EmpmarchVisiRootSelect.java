package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.EmpmarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmarchVisiRootSelect extends ActionVisitorTemplateAction<EmpmarchInfo, EmpmarchInfo> {

	public EmpmarchVisiRootSelect(DeciTreeOption<EmpmarchInfo> option) {
		super(option, EmpmarchInfo.class, EmpmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpmarchInfo>> getTreeClassHook() {
		return EmpmarchRootSelect.class;
	}
	
	
	
	@Override protected List<EmpmarchInfo> toBaseClassHook(List<EmpmarchInfo> baseInfos, List<EmpmarchInfo> results) {
		return results;
	}
}
