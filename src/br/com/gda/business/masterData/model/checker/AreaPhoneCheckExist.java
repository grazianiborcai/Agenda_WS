package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AreaPhoneCheckExist extends ModelCheckerTemplateAction_<AreaPhoneInfo> {
	
	public AreaPhoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AreaPhoneInfo> buildActionHook(AreaPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AreaPhoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AreaPhoneInfo> actionSelect = new StdAreaPhoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AreaPhoneInfo> buildActionOption(AreaPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AreaPhoneInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.AREA_PHONE_ALREADY_EXIST)
			return SystemMessage.AREA_PHONE_ALREADY_EXIST;
		
		return SystemMessage.AREA_PHONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.AREA_PHONE_ALREADY_EXIST;	
			
		return SystemCode.AREA_PHONE_NOT_FOUND;
	}
}
