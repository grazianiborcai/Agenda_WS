package br.com.mind5.masterData.dayParting.model.action;

import java.util.List;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.decisionTree.DaypartRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DaypartVisiRootSelect extends ActionVisitorTemplateAction<DaypartInfo, DaypartInfo> {

	public DaypartVisiRootSelect(DeciTreeOption<DaypartInfo> option) {
		super(option, DaypartInfo.class, DaypartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DaypartInfo>> getTreeClassHook() {
		return DaypartRootSelect.class;
	}
	
	
	
	@Override protected List<DaypartInfo> toBaseClassHook(List<DaypartInfo> baseInfos, List<DaypartInfo> results) {
		return results;
	}
}
