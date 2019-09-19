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
import br.com.gda.payment.storePartner.model.action.LazyStoparSelect;
import br.com.gda.payment.storePartner.model.action.StdStoparEnforceDel;

public final class StoparCheckSoftDelete extends ModelCheckerTemplateAction_<StoparInfo> {
	
	public StoparCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoparInfo> buildActionHook(StoparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StoparInfo> actionSelect = new StdStoparEnforceDel(option);
		actionSelect.addPostAction(new LazyStoparSelect(conn, schemaName));		
		return actionSelect;
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
		return SystemMessage.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;	
	}
}
