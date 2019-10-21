package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreCheckExist extends ModelCheckerTemplateAction_<MatoreInfo> {
	
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
