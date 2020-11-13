package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class EmplateCheckTimeRange extends ModelCheckerTemplateSimple<EmplateInfo> {
	
	
	public EmplateCheckTimeRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplateInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.dateValidFrom == null || recordInfo.dateValidTo == null ||
			recordInfo.timeValidFrom == null || recordInfo.timeValidTo == null	)
			return super.FAILED;	
			
		if (recordInfo.dateValidFrom.isAfter(recordInfo.dateValidTo))			
			return super.FAILED;		
		
		if (recordInfo.dateValidFrom.isEqual(recordInfo.dateValidTo) &&
			recordInfo.timeValidFrom.isAfter(recordInfo.timeValidTo))			
			return super.FAILED;	
		
		if (recordInfo.dateValidFrom.isEqual(recordInfo.dateValidTo) &&
			recordInfo.timeValidFrom.equals(recordInfo.timeValidTo))			
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook(){
		return SystemCode.EMP_LDATE_BAD_TIME_RANGE;
	}
}
