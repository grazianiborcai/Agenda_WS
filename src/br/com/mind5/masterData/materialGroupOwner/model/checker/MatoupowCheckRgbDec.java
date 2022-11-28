package br.com.mind5.masterData.materialGroupOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoupowCheckRgbDec extends ModelCheckerTemplateSimple<MatoupowInfo> {

	public MatoupowCheckRgbDec(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoupowInfo recordInfo, Connection conn, String schemaName) {	
		if (checkColor(recordInfo.rgbDecBlue)  == super.FAILED ||
			checkColor(recordInfo.rgbDecGreen) == super.FAILED ||
			checkColor(recordInfo.rgbDecRed)   == super.FAILED)
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkColor(int color){
		if (color < 0)
			return super.FAILED;
		
		if (color > 255)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_INVALID_F);
		builder.addParam01(SystemCode.MAT_GROUP_OWNER);
		builder.addParam02(SystemCode.MAT_GROUP_OWNER_DEC_COLOR);

		return builder.build();
	}
}
