package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionCurrencySelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CurrencyCheckExist extends ModelCheckerTemplateAction<CurrencyInfo> {
	
	public CurrencyCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<CurrencyInfo> buildActionHook(CurrencyInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CurrencyInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<CurrencyInfo> actionSelect = new ActionCurrencySelect(option);
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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CURRENCY_ALREADY_EXIST)
			return SystemMessage.CURRENCY_ALREADY_EXIST;
		
		return SystemMessage.CURRENCY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CURRENCY_ALREADY_EXIST;	
			
		return SystemCode.CURRENCY_NOT_FOUND;
	}
}
