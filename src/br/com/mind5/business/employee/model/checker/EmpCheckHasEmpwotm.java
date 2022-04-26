package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmpCheckHasEmpwotm extends ModelCheckerTemplateSimple<EmpInfo> {
	
	public EmpCheckHasEmpwotm(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.empwotmes == null)			
			return super.FAILED;		
		
		if (recordInfo.empwotmes.isEmpty())			
			return super.FAILED;			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_MANDATORY_FIELD_EMPTY;
	}
}
