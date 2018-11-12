package br.com.gda.business.form.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.form.model.action.StdAddressFormSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class AddressFormCheckExist extends ModelCheckerTemplateAction<AddressFormInfo> {
	
	public AddressFormCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<AddressFormInfo> buildActionHook(AddressFormInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressFormInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<AddressFormInfo> actionSelect = new StdAddressFormSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<AddressFormInfo> buildActionOption(AddressFormInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<AddressFormInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ADDRESS_FORM_ALREADY_EXIST)
			return SystemMessage.ADDRESS_FORM_ALREADY_EXIST;
		
		return SystemMessage.ADDRESS_FORM_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.ADDRESS_FORM_ALREADY_EXIST;	
			
		return SystemCode.ADDRESS_FORM_NOT_FOUND;
	}
}
