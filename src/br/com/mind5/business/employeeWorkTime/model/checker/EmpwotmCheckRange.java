package br.com.mind5.business.employeeWorkTime.model.checker;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public class EmpwotmCheckRange extends ModelCheckerTemplateSimple<EmpwotmInfo> {
	
	public EmpwotmCheckRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpwotmInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.beginTime == null ||
		     recordInfo.endTime   == null		)
			
			return super.FAILED;
			
		
		if (recordInfo.beginTime.isAfter(recordInfo.endTime))
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.EMP_WTIME_INVALID_RANGE;	
	}
}
