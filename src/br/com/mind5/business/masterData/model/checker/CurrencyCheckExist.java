package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.model.action.StdCurrencySelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CurrencyCheckExist extends ModelCheckerTemplateAction_<CurrencyInfo> {
	
	public CurrencyCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CurrencyInfo> buildActionHook(CurrencyInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CurrencyInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CurrencyInfo> actionSelect = new StdCurrencySelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CurrencyInfo> buildActionOption(CurrencyInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CurrencyInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CURRENCY_ALREADY_EXIST)
			return SystemMessage.CURRENCY_ALREADY_EXIST;
		
		return SystemMessage.CURRENCY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CURRENCY_ALREADY_EXIST;	
			
		return SystemCode.CURRENCY_NOT_FOUND;
	}
}
