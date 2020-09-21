package br.com.mind5.business.storeText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatextCheckLength__ extends ModelCheckerTemplateSimpleV2<StorextInfo> {

	public MatextCheckLength__(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.txtMat_ == null )			
			return super.SUCCESS;
		
		if ( recordInfo.txtMat_.length() <= 15 )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_INVALID_LENGTH;
	}
}
