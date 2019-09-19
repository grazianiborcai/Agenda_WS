package br.com.gda.business.form.formPhone.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.form.formPhone.model.action.StdFormPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FormPhoneCheckExist extends ModelCheckerTemplateAction_<FormPhoneInfo> {
	
	public FormPhoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<FormPhoneInfo> buildActionHook(FormPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FormPhoneInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<FormPhoneInfo> actionSelect = new StdFormPhoneSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<FormPhoneInfo> buildActionOption(FormPhoneInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FormPhoneInfo> option = new DeciTreeOption<>();
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
