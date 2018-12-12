package br.com.gda.business.owner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.decisionTree.ActionOwnerEnforceKey;
import br.com.gda.business.owner.model.decisionTree.HandlerOwnerSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwnerCheckExist extends ModelCheckerTemplateAction<OwnerInfo> {
	
	public OwnerCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<OwnerInfo> buildActionHook(OwnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnerInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<OwnerInfo> actionSelect = new ActionOwnerEnforceKey(option);
		actionSelect.addPostAction(new HandlerOwnerSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<OwnerInfo> buildOption(OwnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnerInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.OWNER_ALREADY_EXIST)
			return SystemMessage.OWNER_ALREADY_EXIST;
		
		return SystemMessage.OWNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.OWNER_ALREADY_EXIST;	
			
		return SystemCode.OWNER_NOT_FOUND;
	}
}
