package br.com.gda.payment.ownerPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.action.StdOwnparSelect;

public final class OwnparCheckExist extends ModelCheckerTemplateAction<OwnparInfo> {
	
	public OwnparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<OwnparInfo> buildActionHook(OwnparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OwnparInfo> select = new StdOwnparSelect(option);
		return select;
	}
	
	
	
	private DeciTreeOption<OwnparInfo> buildActionOption(OwnparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnparInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_PARTNER_OWNER_ALREADY_EXIST)
			return SystemMessage.PAY_PARTNER_OWNER_ALREADY_EXIST;
		
		return SystemMessage.PAY_PARTNER_OWNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_OWNER_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_OWNER_NOT_FOUND;
	}
}
