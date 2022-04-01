package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiRootSelect extends ActionVisitorTemplateAction<CalateInfo, CalateInfo> {

	public CalateVisiRootSelect(DeciTreeOption<CalateInfo> option) {
		super(option, CalateInfo.class, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> toBaseClassHook(List<CalateInfo> baseInfos, List<CalateInfo> results) {
		return results;
	}
}
