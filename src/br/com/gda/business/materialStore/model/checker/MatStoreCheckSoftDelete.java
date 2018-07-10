package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.decisionTree.ActionMatStoreEnforceDel;
import br.com.gda.business.materialStore.model.decisionTree.HandlerMatStoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatStoreCheckSoftDelete extends ModelCheckerTemplateSimple<MatStoreInfo> {
	private final boolean ALREADY_EXIST = true;
	private final boolean NOT_FOUND = false;
	private final boolean FAILED = false;
	private final boolean EMPTY_RESULTSET = false;
	
	private DeciAction<MatStoreInfo> actionSelect;
	private DeciResult<MatStoreInfo> actionResult;
	
	
	public MatStoreCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatStoreInfo recordInfo, Connection conn, String schemaName) {	
		executeAction(recordInfo, conn, schemaName);
		
		if (actionResult.hasSuccessfullyFinished() == FAILED)
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		
		if (actionResult.hasResultset() == EMPTY_RESULTSET)
			return NOT_FOUND;
		
		if (actionResult.getResultset().isEmpty())
			return NOT_FOUND;
		
		return ALREADY_EXIST;
	}
	
	
	
	private void executeAction(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		buildAction(recordInfo, conn, schemaName);
		actionSelect.executeAction();
		actionResult = actionSelect.getDecisionResult();
	}
	
	
	
	private void buildAction(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatStoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		actionSelect = new ActionMatStoreEnforceDel(option);
		actionSelect.addPostAction(new HandlerMatStoreSelect(conn, schemaName));
	}
	
	
	
	private DeciTreeOption<MatStoreInfo> buildActionOption(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatStoreInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_MAT_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MAT_FLAGGED_AS_DELETED;	
	}
}
