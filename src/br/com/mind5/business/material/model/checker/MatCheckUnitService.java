package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.business.masterData.info.common.MatUnit;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class MatCheckUnitService extends ModelCheckerTemplateSimple_<MatInfo> {

	public MatCheckUnitService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (shouldCheck(recordInfo) == false)
			return super.SUCCESS;
		
		if (MatUnit.HOUR.getCodUnit().equals(recordInfo.codUnit) 	||
			MatUnit.MINUTE.getCodUnit().equals(recordInfo.codUnit)		)			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	private boolean shouldCheck(MatInfo recordInfo) {
		if (recordInfo.codUnit == null)
			return false;
		
		if (MatCateg.SERVICE.getCodMatCateg() == recordInfo.codMatCateg )
			return true;
		
		return false;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.MAT_UNIT_INCONSISTENCY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.MAT_UNIT_INCONSISTENCY;
	}
}
