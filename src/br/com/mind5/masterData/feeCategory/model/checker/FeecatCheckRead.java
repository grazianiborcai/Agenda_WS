package br.com.mind5.masterData.feeCategory.model.checker;

import java.sql.Connection;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FeecatCheckRead extends ModelCheckerTemplateSimpleV2<FeecatInfo> {
	
	public FeecatCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeecatInfo recordInfo, Connection conn, String schemaName) {	
		if (  recordInfo.codFeeCateg == DefaultValue.character() ||
			  recordInfo.codLanguage == null 						)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FEE_CATEG_MANDATORY_FIELD_EMPTY;
	}
}
