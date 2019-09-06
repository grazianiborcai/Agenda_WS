package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.business.scheduleMoviment.model.decisionTree.RootSchedovmInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiSchedineInsertSchedovm extends ActionVisitorTemplateAction<SchedineInfo, SchedovmInfo> {

	public VisiSchedineInsertSchedovm(Connection conn, String schemaName) {
		super(conn, schemaName, SchedineInfo.class, SchedovmInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedovmInfo> getActionHook(DeciTreeOption<SchedovmInfo> option) {
		return new RootSchedovmInsert(option).toAction();
	}
	
	
	
	protected List<SchedineInfo> toBaseClassHook(List<SchedineInfo> baseInfos, List<SchedovmInfo> results) {
		return baseInfos;
	}
}
