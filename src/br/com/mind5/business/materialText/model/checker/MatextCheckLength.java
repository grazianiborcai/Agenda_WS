package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatextCheckLength extends ModelCheckerTemplateSimpleV2<MatextInfo> {
	private int MAX_LENGTH = 30;
	
	public MatextCheckLength(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatextInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.txtMat == null )			
			return super.SUCCESS;
		
		if ( recordInfo.txtMat.length() <= MAX_LENGTH )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_TEXT_INVALID_LENGTH;
	}
}
