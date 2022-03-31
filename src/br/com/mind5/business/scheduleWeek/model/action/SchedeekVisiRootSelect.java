package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.model.decisionTree.SchedeekRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiRootSelect extends ActionVisitorTemplateAction<SchedeekInfo, SchedeekInfo> {

	public SchedeekVisiRootSelect(DeciTreeOption<SchedeekInfo> option) {
		super(option, SchedeekInfo.class, SchedeekInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedeekInfo>> getTreeClassHook() {
		return SchedeekRootSelect.class;
	}
	
	
	
	@Override protected List<SchedeekInfo> toBaseClassHook(List<SchedeekInfo> baseInfos, List<SchedeekInfo> results) {
		return results;
	}
}
