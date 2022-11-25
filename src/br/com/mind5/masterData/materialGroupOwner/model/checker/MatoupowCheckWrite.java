package br.com.mind5.masterData.materialGroupOwner.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatoupowCheckWrite extends ModelCheckerTemplateSimple<MatoupowInfo> {

	public MatoupowCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatoupowInfo recordInfo, Connection conn, String schemaName) {
		if ( hasRgbHex(recordInfo) == false &&
			 hasRgbDec(recordInfo) == false) {
			
			return super.FAILED;
		}
		
		
		
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codGroup 	<= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username 	== null) {
			
			return super.FAILED;
		}
		
		
		return super.SUCCESS;
	}
	
	
	private boolean hasRgbHex (MatoupowInfo recordInfo) {
		if (recordInfo.rgbHex == null)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean hasRgbDec (MatoupowInfo recordInfo) {
		if (recordInfo.rgbDecBlue  <= 0 ||
			recordInfo.rgbDecGreen <= 0 ||
			recordInfo.rgbDecRed   <= 0)
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.MAT_GROUP_OWNER);

		return builder.build();
	}
}
