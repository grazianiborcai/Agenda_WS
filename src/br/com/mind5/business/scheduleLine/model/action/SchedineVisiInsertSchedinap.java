package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.decisionTree.RootSchedinapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineVisiInsertSchedinap extends ActionVisitorTemplateAction<SchedineInfo, SchedinapInfo> {

	public SchedineVisiInsertSchedinap(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedinapInfo>> getTreeClassHook() {
		return RootSchedinapInsert.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedinapInfo> results) {
		return SchedineMerger.mergeWithSchedinap(baseInfos, results);
	}
}
