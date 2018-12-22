package br.com.gda.business.materialSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapSelect;
import br.com.gda.business.materialSnapshot.model.action.StdMatSnapEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatSnapCheckExist extends ModelCheckerTemplateAction<MatSnapInfo> {
	
	public MatSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatSnapInfo> buildActionHook(MatSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatSnapInfo> actionSelect = new StdMatSnapEnforceKey(option);
		actionSelect.addPostAction(new LazyMatSnapSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatSnapInfo> buildActionOption(MatSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MATERIAL_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.MATERIAL_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.MATERIAL_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.MATERIAL_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.MATERIAL_SNAPSHOT_NOT_FOUND;
	}
}
