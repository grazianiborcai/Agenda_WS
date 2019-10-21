package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextSelect;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceDel;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckSoftDelete extends ModelCheckerTemplateAction_<MatextInfo> {
	
	public MatextCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(MatextInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatextInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatextInfo> actionSelect = new StdMatextEnforceDel(option);
		actionSelect.addPostAction(new LazyMatextSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatextInfo> buildActionOption(MatextInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatextInfo> option = new DeciTreeOption<>();
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
