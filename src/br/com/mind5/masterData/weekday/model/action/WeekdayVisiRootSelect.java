package br.com.mind5.masterData.weekday.model.action;

import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.WeekdayRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayVisiRootSelect extends ActionVisitorTemplateAction<WeekdayInfo, WeekdayInfo> {

	public WeekdayVisiRootSelect(DeciTreeOption<WeekdayInfo> option) {
		super(option, WeekdayInfo.class, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return WeekdayRootSelect.class;
	}
	
	
	
	@Override protected List<WeekdayInfo> toBaseClassHook(List<WeekdayInfo> baseInfos, List<WeekdayInfo> results) {
		return results;
	}
}
