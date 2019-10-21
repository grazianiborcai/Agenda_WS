package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.action.StdCountrySelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryCheckExist extends ModelCheckerTemplateAction_<CountryInfo> {
	
	public CountryCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CountryInfo> buildActionHook(CountryInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CountryInfo> actionSelect = new StdCountrySelect(option);
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.COUNTRY_ALREADY_EXIST)
			return SystemMessage.COUNTRY_ALREADY_EXIST;
		
		return SystemMessage.COUNTRY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.COUNTRY_ALREADY_EXIST;	
			
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
