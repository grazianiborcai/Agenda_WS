package br.com.gda.business.address.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.StdAddressSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddressCheckLimit extends ModelCheckerTemplateAction_<AddressInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public AddressCheckLimit(ModelCheckerOption option) {
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
	
	
	
	@Override protected boolean hasPassedHook(boolean checkerResult, int recordCount) {
		return (recordCount < MAX_RECORD_COUNT);
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {			
		return SystemMessage.ADDRESS_LIMIT_EXCEEDED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {			
		return SystemCode.ADDRESS_LIMIT_EXCEEDED;
	}
}
