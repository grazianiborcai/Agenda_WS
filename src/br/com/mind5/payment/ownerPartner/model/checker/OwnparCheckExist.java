package br.com.mind5.payment.ownerPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparSelect;

public final class OwnparCheckExist extends ModelCheckerTemplateAction_<OwnparInfo> {
	
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
