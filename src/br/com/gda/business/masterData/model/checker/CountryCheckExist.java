package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionCountrySelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CountryCheckExist extends ModelCheckerTemplateAction<CountryInfo> {
	
	public CountryCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<CountryInfo> buildActionHook(CountryInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<CountryInfo> actionSelect = new ActionCountrySelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CountryInfo> buildActionOption(CountryInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.COUNTRY_ALREADY_EXIST)
			return SystemMessage.COUNTRY_ALREADY_EXIST;
		
		return SystemMessage.COUNTRY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.COUNTRY_ALREADY_EXIST;	
			
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
