package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.action.StdPositionSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PositionCheckExist extends ModelCheckerTemplateAction<PositionInfo> {
	
	public PositionCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PositionInfo> buildActionHook(PositionInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PositionInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PositionInfo> actionSelect = new StdPositionSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PositionInfo> buildActionOption(PositionInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PositionInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.POSITION_ALREADY_EXIST)
			return SystemMessage.POSITION_ALREADY_EXIST;
		
		return SystemMessage.POSITION_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.POSITION_ALREADY_EXIST;	
			
		return SystemCode.POSITION_NOT_FOUND;
	}
}
