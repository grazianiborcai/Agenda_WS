package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.EmplisRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiRootSearch extends ActionVisitorTemplateAction<EmplisInfo, EmplisInfo> {

	public EmplisVisiRootSearch(DeciTreeOption<EmplisInfo> option) {
		super(option, EmplisInfo.class, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return EmplisRootSearch.class;
	}
	
	
	
	@Override protected List<EmplisInfo> toBaseClassHook(List<EmplisInfo> baseInfos, List<EmplisInfo> results) {
		return results;
	}
}
