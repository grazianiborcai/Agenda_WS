package br.com.mind5.business.scheduleYear.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.model.decisionTree.SchedyearRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiRootSelect extends ActionVisitorTemplateAction<SchedyearInfo, SchedyearInfo> {

	public SchedyearVisiRootSelect(DeciTreeOption<SchedyearInfo> option) {
		super(option, SchedyearInfo.class, SchedyearInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedyearInfo>> getTreeClassHook() {
		return SchedyearRootSelect.class;
	}
	
	
	
	@Override protected List<SchedyearInfo> toBaseClassHook(List<SchedyearInfo> baseInfos, List<SchedyearInfo> results) {
		return results;
	}
}
