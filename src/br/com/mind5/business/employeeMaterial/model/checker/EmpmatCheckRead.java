package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpmatCheckRead extends ModelCheckerTemplateSimpleV2<EmpmatInfo> {

	public EmpmatCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner    <= 0
			|| recordInfo.codEmployee <= 0
			|| recordInfo.codMat 	  <= 0
			|| recordInfo.codLanguage == null
			|| recordInfo.username 	  == null	)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_MANDATORY_FIELD_EMPTY;
	}
}
