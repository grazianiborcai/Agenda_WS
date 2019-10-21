package br.com.mind5.payment.setupPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.RootSetuparSelect;

public final class SetuparCheckExist extends ModelCheckerTemplateAction_<SetuparInfo> {
	
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
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_PARTNER_SETUP_ALREADY_EXIST)
			return SystemMessage.PAY_PARTNER_SETUP_ALREADY_EXIST;
		
		return SystemMessage.PAY_PARTNER_SETUP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_SETUP_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_SETUP_NOT_FOUND;
	}
}
