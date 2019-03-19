package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.StdMatoreEnforceDel;
import br.com.gda.business.materialStore.model.action.LazyMatoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatoreCheckSoftDelete extends ModelCheckerTemplateAction<MatoreInfo> {
	
	public MatoreCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatoreInfo> buildActionHook(MatoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatoreInfo> actionSelect = new StdMatoreEnforceDel(option);
		actionSelect.addPostAction(new LazyMatoreSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatoreInfo> buildActionOption(MatoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatoreInfo> option = new DeciTreeOption<>();
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
