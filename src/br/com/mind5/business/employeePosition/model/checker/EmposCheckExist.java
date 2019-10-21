package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.StdEmposSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckExist extends ModelCheckerTemplateAction_<EmposInfo> {
	
	public EmposCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> buildActionHook(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmposInfo> actionSelect = new StdEmposSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmposInfo> buildOption(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMPOS_ALREADY_EXIST)
			return SystemMessage.EMPOS_ALREADY_EXIST;
		
		return SystemMessage.EMPOS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMPOS_ALREADY_EXIST;	
			
		return SystemCode.EMPOS_NOT_FOUND;
	}
}
