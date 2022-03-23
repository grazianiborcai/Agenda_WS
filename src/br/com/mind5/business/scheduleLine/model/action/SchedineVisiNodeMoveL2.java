package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.SchedineNodeMoveL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiNodeMoveL2 extends ActionVisitorTemplateAction<SchedineInfo, SchedineInfo> {

	public SchedineVisiNodeMoveL2(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedineInfo>> getTreeClassHook() {
		return SchedineNodeMoveL2.class;
	}
	
	
	
	@Override protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedineInfo> results) {
		return results;
	}
}
