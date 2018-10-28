package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.model.action.StdStateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StateCheckExist extends ModelCheckerTemplateAction<StateInfo> {
	
	public StateCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StateInfo> buildActionHook(StateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StateInfo> actionSelect = new StdStateSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StateInfo> buildActionOption(StateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STATE_ALREADY_EXIST)
			return SystemMessage.STATE_ALREADY_EXIST;
		
		return SystemMessage.STATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STATE_ALREADY_EXIST;	
			
		return SystemCode.STATE_NOT_FOUND;
	}
}
