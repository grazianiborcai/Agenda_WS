package br.com.mind5.masterData.materialGroupOwner.model.checker;

import java.awt.Color;
import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoupowCheckRgbHex extends ModelCheckerTemplateSimple<MatoupowInfo> {

	public MatoupowCheckRgbHex(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoupowInfo recordInfo, Connection conn, String schemaName) {	
		if (isColor(recordInfo.rgbHex) == super.FAILED)			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isColor(String rgbHex){
		try {
			Color.decode(rgbHex);
			return super.SUCCESS;
			
		} catch(Exception e) {
			return super.FAILED;
		}
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_INVALID_F);
		builder.addParam01(SystemCode.MAT_GROUP_OWNER);
		builder.addParam02(SystemCode.MAT_GROUP_OWNER_HEX_COLOR);

		return builder.build();
	}
}
