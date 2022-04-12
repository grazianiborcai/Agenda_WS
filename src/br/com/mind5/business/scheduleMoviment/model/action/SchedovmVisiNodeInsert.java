package br.com.mind5.business.scheduleMoviment.model.action;

import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.decisionTree.SchedovmNodeInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedovmVisiNodeInsert extends ActionVisitorTemplateAction<SchedovmInfo, SchedovmInfo> {

	public SchedovmVisiNodeInsert(DeciTreeOption<SchedovmInfo> option) {
		super(option, SchedovmInfo.class, SchedovmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedovmInfo>> getTreeClassHook() {
		return SchedovmNodeInsert.class;
	}
	
	
	
	@Override protected List<SchedovmInfo> toBaseClassHook(List<SchedovmInfo> baseInfos, List<SchedovmInfo> results) {
		return results;
	}
}
