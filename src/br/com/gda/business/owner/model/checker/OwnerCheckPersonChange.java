package br.com.gda.business.owner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerSelect;
import br.com.gda.business.owner.model.action.StdOwnerEnforcePersonChange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwnerCheckPersonChange extends ModelCheckerTemplateAction<OwnerInfo> {
	
	public OwnerCheckPersonChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<OwnerInfo> buildActionHook(OwnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnerInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OwnerInfo> actionSelect = new StdOwnerEnforcePersonChange(option);
		actionSelect.addPostAction(new LazyOwnerSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<OwnerInfo> buildActionOption(OwnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwnerInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.OWNER_PERSON_NOT_CHANGED)
			return SystemMessage.OWNER_PERSON_NOT_CHANGED;
		
		return SystemMessage.OWNER_PERSON_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.OWNER_PERSON_NOT_CHANGED;	
			
		return SystemCode.OWNER_PERSON_CANT_BE_CHANGED;
	}
}
