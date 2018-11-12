package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.ActionMatStoreEnforceDel;
import br.com.gda.business.materialStore.model.decisionTree.HandlerMatStoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatStoreCheckSoftDelete extends ModelCheckerTemplateAction<MatStoreInfo> {
	
	public MatStoreCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatStoreInfo> buildActionHook(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatStoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatStoreInfo> actionSelect = new ActionMatStoreEnforceDel(option);
		actionSelect.addPostAction(new HandlerMatStoreSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatStoreInfo> buildActionOption(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatStoreInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_MAT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MAT_FLAGGED_AS_DELETED;	
	}
}
