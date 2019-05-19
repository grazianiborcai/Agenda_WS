package br.com.gda.business.snapshot_.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.action.StdSnapSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SnapCheckExist extends ModelCheckerTemplateAction<SnapInfo> {
	
	public SnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<SnapInfo> buildActionHook(SnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SnapInfo> actionSelect = new StdSnapSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<SnapInfo> buildActionOption(SnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.SNAPSHOT_NOT_FOUND;
	}
}
