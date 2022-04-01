package br.com.mind5.business.calendarTimeStore.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.decisionTree.CalimoreNodeSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimoreVisiNodeSelect extends ActionVisitorTemplateAction<CalimoreInfo, CalimoreInfo> {

	public CalimoreVisiNodeSelect(DeciTreeOption<CalimoreInfo> option) {
		super(option, CalimoreInfo.class, CalimoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalimoreInfo>> getTreeClassHook() {
		return CalimoreNodeSelect.class;
	}
	
	
	
	@Override protected List<CalimoreInfo> toBaseClassHook(List<CalimoreInfo> baseInfos, List<CalimoreInfo> results) {
		return results;
	}
}
