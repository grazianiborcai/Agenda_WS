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

public final class PhoneCheckLimit extends ModelCheckerTemplateAction<PhoneInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public PhoneCheckLimit(ModelCheckerOption option) {
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
	
	
	
	@Override protected boolean hasPassedHook(boolean checkerResult, int recordCount) {
		return (recordCount < MAX_RECORD_COUNT);
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {			
		return SystemMessage.PHONE_LIMIT_EXCEEDED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {			
		return SystemCode.PHONE_LIMIT_EXCEEDED;
	}
}
