package br.com.mind5.business.employeeLunchTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.business.employeeLunchTimeSearch.model.decisionTree.EmplutmarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplutmarchVisiRootSelect extends ActionVisitorTemplateAction<EmplutmarchInfo, EmplutmarchInfo> {

	public EmplutmarchVisiRootSelect(DeciTreeOption<EmplutmarchInfo> option) {
		super(option, EmplutmarchInfo.class, EmplutmarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplutmarchInfo>> getTreeClassHook() {
		return EmplutmarchRootSelect.class;
	}
	
	
	
	@Override protected List<EmplutmarchInfo> toBaseClassHook(List<EmplutmarchInfo> baseInfos, List<EmplutmarchInfo> results) {
		return results;
	}
}
