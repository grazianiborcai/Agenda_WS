package br.com.gda.business.phoneSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.action.StdPhoneSnapSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneSnapCheckExist extends ModelCheckerTemplateAction<PhoneSnapInfo> {
	
	public PhoneSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PhoneSnapInfo> buildActionHook(PhoneSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PhoneSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PhoneSnapInfo> actionSelect = new StdPhoneSnapSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PhoneSnapInfo> buildActionOption(PhoneSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PhoneSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PHONE_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.PHONE_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.PHONE_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PHONE_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.PHONE_SNAPSHOT_NOT_FOUND;
	}
}
