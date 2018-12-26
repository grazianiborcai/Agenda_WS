package br.com.gda.payService.payPartnerStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;
import br.com.gda.payService.payPartnerStore.model.decisionTree.RootPayPartnerStoreSelect;

public final class PayPartnerStoreCheckExist extends ModelCheckerTemplateAction<PayPartnerStoreInfo> {
	
	public PayPartnerStoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PayPartnerStoreInfo> buildActionHook(PayPartnerStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayPartnerStoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayPartnerStoreInfo> select = new RootPayPartnerStoreSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<PayPartnerStoreInfo> buildActionOption(PayPartnerStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayPartnerStoreInfo> option = new DeciTreeOption<>();
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
