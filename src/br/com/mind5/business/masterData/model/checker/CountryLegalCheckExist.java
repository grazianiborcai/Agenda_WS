package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.action.StdCountryLegalSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountryLegalCheckExist extends ModelCheckerTemplateAction_<CountryLegalInfo> {
	
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
