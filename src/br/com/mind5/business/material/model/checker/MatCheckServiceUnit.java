package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialUnit.info.Matunit;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatCheckServiceUnit extends ModelCheckerTemplateSimple<MatInfo> {

	public MatCheckServiceUnit(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUnit == null)
			return super.FAILED;
		
		
		if (Matunit.HOUR.getCodUnit().equals(recordInfo.codUnit))	
			return super.SUCCESS;		
		
		
		if (Matunit.MINUTE.getCodUnit().equals(recordInfo.codUnit))					
			return super.SUCCESS;	
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SERVICE_UNIT_INCONSISTENCY;
	}
}
