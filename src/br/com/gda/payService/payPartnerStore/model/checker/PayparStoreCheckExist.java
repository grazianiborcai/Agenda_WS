package br.com.gda.payService.payPartnerStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;
import br.com.gda.payService.payPartnerStore.model.decisionTree.RootPayparStoreSelect;

public final class PayparStoreCheckExist extends ModelCheckerTemplateAction<PayparStoreInfo> {
	
	public PayparStoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PayparStoreInfo> buildActionHook(PayparStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayparStoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayparStoreInfo> select = new RootPayparStoreSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<PayparStoreInfo> buildActionOption(PayparStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayparStoreInfo> option = new DeciTreeOption<>();
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
