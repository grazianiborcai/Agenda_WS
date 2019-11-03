package br.com.mind5.business.employee.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class EmpCheckHasPhone extends ModelCheckerTemplateSimpleV2<EmpInfo> {
	
	public EmpCheckHasPhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.phones == null)			
			return super.FAILED;		
		
		if (recordInfo.phones.isEmpty())			
				return super.FAILED;			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.EMP_PHONE_IS_FILLED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_PHONE_IS_NULL;
	}	
}
