package br.com.gda.security.userPassword.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.action.StdUpswdSelect;

public final class UpswdCheckExist extends ModelCheckerTemplateAction_<UpswdInfo> {
	
	public UpswdCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> buildActionHook(UpswdInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UpswdInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<UpswdInfo> actionSelect = new StdUpswdSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<UpswdInfo> buildOption(UpswdInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<UpswdInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
