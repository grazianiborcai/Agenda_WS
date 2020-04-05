package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.business.scheduleMoviment.model.decisionTree.RootSchedovmInsert;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineInsertSchedovm extends ActionVisitorTemplateActionV1<SchedineInfo, SchedovmInfo> {

	public VisiSchedineInsertSchedovm(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class, SchedovmInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedovmInfo> getActionHook(DeciTreeOption<SchedovmInfo> option) {
		return new RootSchedovmInsert(option).toAction();
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedovmInfo> results) {
		return baseInfos;
	}
}
