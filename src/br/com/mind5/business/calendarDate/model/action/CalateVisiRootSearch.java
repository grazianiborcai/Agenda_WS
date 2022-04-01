package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiRootSearch extends ActionVisitorTemplateAction<CalateInfo, CalateInfo> {

	public CalateVisiRootSearch(DeciTreeOption<CalateInfo> option) {
		super(option, CalateInfo.class, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSearch.class;
	}
	
	
	
	@Override protected List<CalateInfo> toBaseClassHook(List<CalateInfo> baseInfos, List<CalateInfo> results) {
		return results;
	}
}
