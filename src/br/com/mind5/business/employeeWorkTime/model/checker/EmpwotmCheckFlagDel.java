package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpwotmCheckFlagDel extends ModelCheckerTemplateSimple<EmpwotmInfo> {

	public EmpwotmCheckFlagDel(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.isDeleted )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_MANDATORY_FIELD_EMPTY;
	}
}
