package br.com.mind5.business.employeeMaterial.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpmatCheckDeleteByEmp extends ModelCheckerTemplateSimple<EmpmatInfo> {

	public EmpmatCheckDeleteByEmp(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpmatInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codEmployee	<= 0 	||
			 recordInfo.username	== null	||
			 recordInfo.codLanguage	== null 	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MAT_MANDATORY_FIELD_EMPTY;
	}
}
