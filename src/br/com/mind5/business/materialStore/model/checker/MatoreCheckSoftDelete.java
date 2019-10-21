package br.com.mind5.business.materialStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatoreCheckSoftDelete extends ModelCheckerTemplateAction_<MatoreInfo> {
	
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
		return SystemMessage.MAT_STORE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.MAT_STORE_FLAGGED_AS_DELETED;	
	}
}
