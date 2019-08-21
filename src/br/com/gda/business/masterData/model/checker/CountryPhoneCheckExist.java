package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CountryPhoneCheckExist extends ModelCheckerTemplateAction<CountryPhoneInfo> {
	
	public CountryPhoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CountryPhoneInfo> buildActionHook(CountryPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryPhoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CountryPhoneInfo> actionSelect = new StdCountryPhoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CountryPhoneInfo> buildActionOption(CountryPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryPhoneInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.COUNTRY_PHONE_ALREADY_EXIST)
			return SystemMessage.COUNTRY_PHONE_ALREADY_EXIST;
		
		return SystemMessage.COUNTRY_PHONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.COUNTRY_ALREADY_EXIST;	
			
		return SystemCode.COUNTRY_NOT_FOUND;
	}
}
