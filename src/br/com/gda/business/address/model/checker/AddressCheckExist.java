package br.com.gda.business.address.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddressCheckExist extends ModelCheckerTemplateAction<AddressInfo> {
	
	public AddressCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AddressInfo> buildActionHook(AddressInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AddressInfo> actionSelect = new StdAddressSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AddressInfo> buildActionOption(AddressInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.ADDRESS_ALREADY_EXIST)
			return SystemMessage.ADDRESS_ALREADY_EXIST;
		
		return SystemMessage.ADDRESS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.ADDRESS_ALREADY_EXIST;	
			
		return SystemCode.ADDRESS_NOT_FOUND;
	}
}
