package br.com.gda.business.address.model.checker;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class AddressCheckNewRecord extends ModelCheckerTemplateSimple_<AddressInfo> {

	public AddressCheckNewRecord(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(AddressInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codAddress <= 0 )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.ADDRESS_IS_OLD )
			return SystemMessage.ADDRESS_IS_OLD;
		
		return SystemMessage.ADDRESS_IS_NEW;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.ADDRESS_IS_OLD;	
			
		return SystemCode.ADDRESS_IS_NEW;
	}
}
