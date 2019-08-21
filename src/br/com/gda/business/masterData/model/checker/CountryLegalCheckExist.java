package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.model.action.StdCountryLegalSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CountryLegalCheckExist extends ModelCheckerTemplateAction<CountryLegalInfo> {
	
	public CountryLegalCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CountryLegalInfo> buildActionHook(CountryLegalInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryLegalInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CountryLegalInfo> actionSelect = new StdCountryLegalSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CountryLegalInfo> buildActionOption(CountryLegalInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CountryLegalInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.COUNTRY_LEGAL_ALREADY_EXIST)
			return SystemMessage.COUNTRY_LEGAL_ALREADY_EXIST;
		
		return SystemMessage.COUNTRY_LEGAL_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.COUNTRY_LEGAL_ALREADY_EXIST;	
			
		return SystemCode.COUNTRY_LEGAL_NOT_FOUND;
	}
}
