package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.decisionTree.RootSchedovmInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiInsertSchedovm extends ActionVisitorTemplateAction<SchedineInfo, SchedovmInfo> {

	public SchedineVisiInsertSchedovm(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedovmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedovmInfo>> getTreeClassHook() {
		return RootSchedovmInsert.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedovmInfo> results) {
		return baseInfos;
	}
}
