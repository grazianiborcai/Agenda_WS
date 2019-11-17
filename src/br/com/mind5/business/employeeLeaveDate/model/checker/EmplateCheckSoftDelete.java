package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateCheckSoftDelete extends ModelCheckerTemplateAction_<EmplateInfo> {	
	
	public EmplateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> buildActionHook(EmplateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmplateInfo> actionSelect = new StdEmplateEnforceDel(option);
		actionSelect.addPostAction(new LazyEmplateSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmplateInfo> buildActionOption(EmplateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_LDATE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMP_LDATE_FLAGGED_AS_DELETED;	
	}
}
