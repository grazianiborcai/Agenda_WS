package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.decisionTree.CalimempNodeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimempVisiNodeSelect extends ActionVisitorTemplateAction<CalimempInfo, CalimempInfo> {

	public CalimempVisiNodeSelect(DeciTreeOption<CalimempInfo> option) {
		super(option, CalimempInfo.class, CalimempInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalimempInfo>> getTreeClassHook() {
		return CalimempNodeSelect.class;
	}
	
	
	
	@Override protected List<CalimempInfo> toBaseClassHook(List<CalimempInfo> baseInfos, List<CalimempInfo> results) {
		return results;
	}
}
