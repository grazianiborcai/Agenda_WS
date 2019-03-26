package br.com.gda.business.material.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.MatUnit;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatCheckUnitEach extends ModelCheckerTemplateSimple<MatInfo> {

	public MatCheckUnitEach() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (shouldCheck(recordInfo) == false)
			return super.SUCCESS;
		
		if (recordInfo.priceUnit == 1)			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	private boolean shouldCheck(MatInfo recordInfo) {
		if (recordInfo.codUnit == null)
			return false;
		
		if (MatUnit.EACH.getCodUnit().equals(recordInfo.codUnit))
			return true;
		
		return false;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_UNIT_EACH_INCONSISTENCY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_UNIT_EACH_INCONSISTENCY;
	}
}
