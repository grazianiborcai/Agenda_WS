package br.com.mind5.form.formAddressSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FormesarchCheckRead extends ModelCheckerTemplateSimpleV2<FormesarchInfo> {

	public FormesarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FormesarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codCountry == null )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
