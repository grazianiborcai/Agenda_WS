package br.com.gda.payment.countryPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.decisionTree.RootCounparSelect;

public final class CounparCheckExist extends ModelCheckerTemplateAction_<CounparInfo> {
	
	public CounparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CounparInfo> buildActionHook(CounparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CounparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CounparInfo> select = new RootCounparSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<CounparInfo> buildActionOption(CounparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CounparInfo> option = new DeciTreeOption<>();
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
