package br.com.gda.business.form.formAddress.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FormAddressCheckExist extends ModelCheckerTemplateAction<FormAddressInfo> {
	
	public FormAddressCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<FormAddressInfo> buildActionHook(FormAddressInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FormAddressInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<FormAddressInfo> actionSelect = new StdFormAddressSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<FormAddressInfo> buildActionOption(FormAddressInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FormAddressInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.FORM_ADDRESS_ALREADY_EXIST)
			return SystemMessage.FORM_ADDRESS_ALREADY_EXIST;
		
		return SystemMessage.FORM_ADDRESS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.FORM_ADDRESS_ALREADY_EXIST;	
			
		return SystemCode.FORM_ADDRESS_NOT_FOUND;
	}
}
