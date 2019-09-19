package br.com.gda.payment.storePartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

public final class StoparCheckExist extends ModelCheckerTemplateAction_<StoparInfo> {
	
	public StoparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<StoparInfo> buildActionHook(StoparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StoparInfo> select = new RootStoparSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<StoparInfo> buildActionOption(StoparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoparInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_PARTNER_STORE_ALREADY_EXIST)
			return SystemMessage.PAY_PARTNER_STORE_ALREADY_EXIST;
		
		return SystemMessage.PAY_PARTNER_STORE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_STORE_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
