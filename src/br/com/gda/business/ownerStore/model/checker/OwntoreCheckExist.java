package br.com.gda.business.ownerStore.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.model.decisionTree.RootOwntoreSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OwntoreCheckExist extends ModelCheckerTemplateAction_<OwntoreInfo> {
	
	public OwntoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<OwntoreInfo> buildActionHook(OwntoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwntoreInfo> option = buildOption(recordInfo, conn, schemaName);		
		return new RootOwntoreSelect(option).toAction();
	}
	
	
	
	private DeciTreeOption<OwntoreInfo> buildOption(OwntoreInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OwntoreInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.OWNER_STORE_ALREADY_EXIST)
			return SystemMessage.OWNER_STORE_ALREADY_EXIST;
		
		return SystemMessage.OWNER_STORE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.OWNER_ALREADY_EXIST;	
			
		return SystemCode.OWNER_NOT_FOUND;
	}
}
