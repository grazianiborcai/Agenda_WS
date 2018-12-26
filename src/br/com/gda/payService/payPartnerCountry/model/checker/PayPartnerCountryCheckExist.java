package br.com.gda.payService.payPartnerCountry.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.decisionTree.RootPayPartnerCountrySelect;

public final class PayPartnerCountryCheckExist extends ModelCheckerTemplateAction<PayPartnerCountryInfo> {
	
	public PayPartnerCountryCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PayPartnerCountryInfo> buildActionHook(PayPartnerCountryInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayPartnerCountryInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayPartnerCountryInfo> select = new RootPayPartnerCountrySelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<PayPartnerCountryInfo> buildActionOption(PayPartnerCountryInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayPartnerCountryInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_PARTNER_COUNTRY_ALREADY_EXIST)
			return SystemMessage.PAY_PARTNER_COUNTRY_ALREADY_EXIST;
		
		return SystemMessage.PAY_PARTNER_COUNTRY_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_COUNTRY_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_COUNTRY_NOT_FOUND;
	}
}
