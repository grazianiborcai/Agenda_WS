package br.com.gda.business.phone.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneCheckExist extends ModelCheckerTemplateAction<PhoneInfo> {
	
	public PhoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> buildActionHook(PhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PhoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PhoneInfo> actionSelect = new StdPhoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PhoneInfo> buildActionOption(PhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PhoneInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PHONE_ALREADY_EXIST)
			return SystemMessage.PHONE_ALREADY_EXIST;
		
		return SystemMessage.PHONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PHONE_ALREADY_EXIST;	
			
		return SystemCode.PHONE_NOT_FOUND;
	}
}
