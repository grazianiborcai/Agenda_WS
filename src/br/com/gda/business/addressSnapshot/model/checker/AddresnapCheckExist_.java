package br.com.gda.business.addressSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.action.StdAddresnapSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddresnapCheckExist_ extends ModelCheckerTemplateAction<AddresnapInfo> {
	
	public AddresnapCheckExist_(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AddresnapInfo> buildActionHook(AddresnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddresnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AddresnapInfo> actionSelect = new StdAddresnapSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AddresnapInfo> buildActionOption(AddresnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddresnapInfo> option = new DeciTreeOption<>();
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
