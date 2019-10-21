package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.business.masterData.model.action.StdMonthSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MonthCheckExist extends ModelCheckerTemplateAction_<MonthInfo> {
	
	public MonthCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MonthInfo> buildActionHook(MonthInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MonthInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MonthInfo> actionSelect = new StdMonthSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MonthInfo> buildActionOption(MonthInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MonthInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MONTH_ALREADY_EXIST)
			return SystemMessage.MONTH_ALREADY_EXIST;
		
		return SystemMessage.MONTH_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MONTH_ALREADY_EXIST;	
			
		return SystemCode.MONTH_NOT_FOUND;
	}
}
