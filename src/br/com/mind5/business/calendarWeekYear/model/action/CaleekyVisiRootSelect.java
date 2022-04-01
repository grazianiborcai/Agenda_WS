package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.decisionTree.CaleekyRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CaleekyVisiRootSelect extends ActionVisitorTemplateAction<CaleekyInfo, CaleekyInfo> {

	public CaleekyVisiRootSelect(DeciTreeOption<CaleekyInfo> option) {
		super(option, CaleekyInfo.class, CaleekyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CaleekyInfo>> getTreeClassHook() {
		return CaleekyRootSelect.class;
	}
	
	
	
	@Override protected List<CaleekyInfo> toBaseClassHook(List<CaleekyInfo> baseInfos, List<CaleekyInfo> results) {
		return results;
	}
}
