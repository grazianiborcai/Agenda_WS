package br.com.mind5.business.scheduleLine.model.action;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.decisionTree.RootSchedinapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineInsertSchedinap extends ActionVisitorTemplateActionV2<SchedineInfo, SchedinapInfo> {

	public VisiSchedineInsertSchedinap(DeciTreeOption<SchedineInfo> option) {
		super(option, SchedineInfo.class, SchedinapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SchedinapInfo>> getTreeClassHook() {
		return RootSchedinapInsert.class;
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedinapInfo> results) {
		return SchedineMerger.mergeWithSchedinap(baseInfos, results);
	}
}
