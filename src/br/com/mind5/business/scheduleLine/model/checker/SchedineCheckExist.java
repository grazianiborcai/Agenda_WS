package br.com.mind5.business.scheduleLine.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineRootSelect;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedineCheckExist extends ModelCheckerTemplateAction_<SchedineInfo> {
	
	public SchedineCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<SchedineInfo> buildActionHook(SchedineInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SchedineInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SchedineInfo> enforceKey = new StdSchedineEnforceKey(option);
		ActionLazy<SchedineInfo> select = new LazySchedineRootSelect(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);		
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<SchedineInfo> buildActionOption(SchedineInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SchedineInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.SCHEDULE_ALREADY_EXIST)
			return SystemMessage.SCHEDULE_ALREADY_EXIST;
		
		return SystemMessage.SCHEDULE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.SCHEDULE_ALREADY_EXIST;	
		
		return SystemCode.SCHEDULE_NOT_FOUND;
	}
}
