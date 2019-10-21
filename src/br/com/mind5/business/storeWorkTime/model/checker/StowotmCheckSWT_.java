package br.com.mind5.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmSelectRange_;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckSWT_ extends ModelCheckerTemplateAction_<StowotmInfo> {
	
	public StowotmCheckSWT_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> buildActionHook(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<StowotmInfo> actionSelect = new StdStowotmSelectRange_(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StowotmInfo> buildOption(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_WTIME_VALID_WORKHOUR)
			return SystemMessage.STORE_WTIME_VALID_WORKHOUR;
		
		return SystemMessage.STORE_WTIME_WORKHOUR_OUT_OF_RANGE;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_WTIME_WORKHOUR_OUT_OF_RANGE;	
			
		return SystemCode.STORE_WTIME_NOT_FOUND;
	}
}
