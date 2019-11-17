package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateEnforceEmposKey_;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class EmplateCheckHasEmposItem extends ModelCheckerTemplateAction_<EmplateInfo> {
	
	public EmplateCheckHasEmposItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> buildActionHook(EmplateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmplateInfo> enforceEmposKey = new StdEmplateEnforceEmposKey_(option);
		ActionLazy<EmplateInfo> select = new LazyEmplateSelect(option.conn, option.schemaName);
		
		enforceEmposKey.addPostAction(select);		
		return enforceEmposKey;
	}
	
	
	
	private DeciTreeOption<EmplateInfo> buildOption(EmplateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmplateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMP_LDATE_ALREADY_EXIST)
			return SystemMessage.EMP_LDATE_ALREADY_EXIST;
		
		return SystemMessage.EMP_LDATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.EMP_LDATE_ALREADY_EXIST;	
			
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
