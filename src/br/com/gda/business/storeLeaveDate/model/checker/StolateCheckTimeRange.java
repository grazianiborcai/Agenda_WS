package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class StolateCheckTimeRange extends ModelCheckerTemplateSimpleV2<StolateInfo> {
	
	
	public StolateCheckTimeRange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StolateInfo recordInfo, Connection conn, String schemaName) {	
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
		return SystemCode.STORE_LDATE_BAD_TIME_RANGE;
	}
}
