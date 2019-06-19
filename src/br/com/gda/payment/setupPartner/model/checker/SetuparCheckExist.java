package br.com.gda.payment.setupPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.setupPartner.model.decisionTree.RootSetuparSelect;

public final class SetuparCheckExist extends ModelCheckerTemplateAction<SetuparInfo> {
	
	public SetuparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<SetuparInfo> buildActionHook(SetuparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SetuparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SetuparInfo> select = new RootSetuparSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<SetuparInfo> buildActionOption(SetuparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SetuparInfo> option = new DeciTreeOption<>();
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
