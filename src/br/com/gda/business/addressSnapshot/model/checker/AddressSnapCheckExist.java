package br.com.gda.business.addressSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.action.StdAddressSnapSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddressSnapCheckExist extends ModelCheckerTemplateAction<AddressSnapInfo> {
	
	public AddressSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AddressSnapInfo> buildActionHook(AddressSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AddressSnapInfo> actionSelect = new StdAddressSnapSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AddressSnapInfo> buildActionOption(AddressSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ADDRESS_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.ADDRESS_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.ADDRESS_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.ADDRESS_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.ADDRESS_SNAPSHOT_NOT_FOUND;
	}
}
