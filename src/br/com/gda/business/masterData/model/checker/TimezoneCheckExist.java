package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.action.StdTimezoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class TimezoneCheckExist extends ModelCheckerTemplateAction<TimezoneInfo> {	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<TimezoneInfo> buildActionHook(TimezoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<TimezoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<TimezoneInfo> actionSelect = new StdTimezoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<TimezoneInfo> buildActionOption(TimezoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<TimezoneInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.TIMEZONE_ALREADY_EXIST)
			return SystemMessage.TIMEZONE_ALREADY_EXIST;
		
		return SystemMessage.TIMEZONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.TIMEZONE_ALREADY_EXIST;	
			
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}
