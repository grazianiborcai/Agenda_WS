package br.com.gda.business.feeOwner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.action.StdFeewnerSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeewnerCheckExist extends ModelCheckerTemplateAction_<FeewnerInfo> {
	
	public FeewnerCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<FeewnerInfo> buildActionHook(FeewnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeewnerInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<FeewnerInfo> select = new StdFeewnerSelect(option);
		return select;
	}
	
	
	
	private DeciTreeOption<FeewnerInfo> buildActionOption(FeewnerInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeewnerInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_FEE_ALREADY_EXIST)
			return SystemMessage.STORE_FEE_ALREADY_EXIST;
		
		return SystemMessage.STORE_FEE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STORE_FEE_ALREADY_EXIST;	
			
		return SystemCode.STORE_FEE_NOT_FOUND;
	}
}
