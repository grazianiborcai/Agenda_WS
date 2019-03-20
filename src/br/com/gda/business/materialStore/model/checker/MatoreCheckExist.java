package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatoreCheckExist extends ModelCheckerTemplateAction<MatoreInfo> {
	
	public MatoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> buildActionHook(MatoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatoreInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatoreInfo> select = new RootMatoreSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<MatoreInfo> buildOption(MatoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatoreInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_STORE_ALREADY_EXIST)
			return SystemMessage.MAT_STORE_ALREADY_EXIST;
		
		return SystemMessage.MAT_STORE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_STORE_ALREADY_EXIST;	
			
		return SystemCode.MAT_STORE_NOT_FOUND;
	}
}
