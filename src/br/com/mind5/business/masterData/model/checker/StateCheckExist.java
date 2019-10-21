package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.model.action.StdStateSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StateCheckExist extends ModelCheckerTemplateAction_<StateInfo> {
	
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STATE_ALREADY_EXIST)
			return SystemMessage.STATE_ALREADY_EXIST;
		
		return SystemMessage.STATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STATE_ALREADY_EXIST;	
			
		return SystemCode.STATE_NOT_FOUND;
	}
}
