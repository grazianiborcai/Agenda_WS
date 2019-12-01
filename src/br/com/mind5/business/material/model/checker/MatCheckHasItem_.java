package br.com.mind5.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatSelect;
import br.com.mind5.business.material.model.action.StdMatEnforceOwnerKey_;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCheckHasItem_ extends ModelCheckerTemplateAction_<MatInfo> {	
	
	public MatCheckHasItem_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatInfo> actionSelect = new StdMatEnforceOwnerKey_(option);
		actionSelect.addPostAction(new LazyMatSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatInfo> buildOption(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_HAS_ITEM)
			return SystemMessage.MAT_HAS_ITEM;
		
		return SystemMessage.MAT_NO_ITEM_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_HAS_ITEM;	
			
		return SystemCode.MAT_NO_ITEM_FOUND;
	}
}
