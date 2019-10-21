package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckSoftDelete extends ModelCheckerTemplateAction_<EmposInfo> {
	
	public EmposCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> buildActionHook(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<EmposInfo> actionSelect = new StdEmposEnforceDel(option);
		actionSelect.addPostAction(new LazyEmposSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmposInfo> buildActionOption(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMPOS_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.EMPOS_FLAGGED_AS_DELETED;	
	}
}
