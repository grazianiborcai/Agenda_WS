package br.com.gda.business.feeStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeeStoreSelectService;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeeStoreCheckExistService extends ModelCheckerTemplateAction<FeeStoreInfo> {
	
	public FeeStoreCheckExistService(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<FeeStoreInfo> buildActionHook(FeeStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeeStoreInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<FeeStoreInfo> select = new RootFeeStoreSelectService(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<FeeStoreInfo> buildActionOption(FeeStoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeeStoreInfo> option = new DeciTreeOption<>();
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
