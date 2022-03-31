package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.decisionTree.SchedayRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayVisiRootSelect extends ActionVisitorTemplateAction<SchedayInfo, SchedayInfo> {

	public SchedayVisiRootSelect(DeciTreeOption<SchedayInfo> option) {
		super(option, SchedayInfo.class, SchedayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedayInfo>> getTreeClassHook() {
		return SchedayRootSelect.class;
	}
	
	
	
	@Override protected List<SchedayInfo> toBaseClassHook(List<SchedayInfo> baseInfos, List<SchedayInfo> results) {
		return results;
	}
}
