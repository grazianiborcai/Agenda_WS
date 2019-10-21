package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.scheduleLineSnapshot.model.decisionTree.RootSchedinapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineInsertSchedinap extends ActionVisitorTemplateAction<SchedineInfo, SchedinapInfo> {

	public VisiSchedineInsertSchedinap(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class, SchedinapInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedinapInfo> getActionHook(DeciTreeOption<SchedinapInfo> option) {
		return new RootSchedinapInsert(option).toAction();
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedinapInfo> results) {
		return SchedineMerger.mergeWithSchedinap(results, baseInfos);
	}
}
