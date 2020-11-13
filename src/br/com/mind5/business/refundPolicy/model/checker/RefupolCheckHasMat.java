package br.com.mind5.business.refundPolicy.model.checker;

import java.sql.Connection;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class RefupolCheckHasMat extends ModelCheckerTemplateSimple<RefupolInfo> {

	public RefupolCheckHasMat(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(RefupolInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codMat 		<= 0 	||
			 recordInfo.username 	== null ||
			 recordInfo.codLanguage == null 	)	
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.REFUPOL_MANDATORY_FIELD_EMPTY;
	}
}
