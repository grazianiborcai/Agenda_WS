package br.com.mind5.business.scheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.model.decisionTree.SchedmonRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedmonVisiRootSelect extends ActionVisitorTemplateAction<SchedmonInfo, SchedmonInfo> {

	public SchedmonVisiRootSelect(DeciTreeOption<SchedmonInfo> option) {
		super(option, SchedmonInfo.class, SchedmonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedmonInfo>> getTreeClassHook() {
		return SchedmonRootSelect.class;
	}
	
	
	
	@Override protected List<SchedmonInfo> toBaseClassHook(List<SchedmonInfo> baseInfos, List<SchedmonInfo> results) {
		return results;
	}
}
