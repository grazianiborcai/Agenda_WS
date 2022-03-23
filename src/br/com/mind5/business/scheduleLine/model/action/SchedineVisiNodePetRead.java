package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.decisionTree.SchedineNodePetRead;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiNodePetRead extends ActionVisitorTemplateAction<SchedineInfo, SchedineInfo> {

	public SchedineVisiNodePetRead(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedineInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedineInfo>> getTreeClassHook() {
		return SchedineNodePetRead.class;
	}
	
	
	
	@Override protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedineInfo> results) {
		return results;
	}
}
