package br.com.gda.file.fileImage.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class FimgCheckIsOwner extends ModelCheckerTemplateSimpleV2<FimgInfo> {

	public FimgCheckIsOwner(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwnerRef <= 0 )			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_IS_NOT_OWNER;
	}
}
