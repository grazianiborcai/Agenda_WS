package br.com.mind5.business.employeePosition.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.action.LazyEmposSelect;
import br.com.mind5.business.employeePosition.model.action.StdEmposEnforceEmpKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmposCheckHasEmpItem extends ModelCheckerTemplateAction_<EmposInfo> {	
	
	public EmposCheckHasEmpItem(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> buildActionHook(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<EmposInfo> actionSelect = new StdEmposEnforceEmpKey(option);
		actionSelect.addPostAction(new LazyEmposSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmposInfo> buildOption(EmposInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmposInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.EMPOS_HAS_ITEM)
			return SystemMessage.EMPOS_HAS_ITEM;
		
		return SystemMessage.EMPOS_NO_ITEM_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.EMPOS_HAS_ITEM;	
			
		return SystemCode.EMPOS_NO_ITEM_FOUND;
	}
}
