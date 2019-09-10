package br.com.gda.file.fileUpload.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.model.action.StdFilupSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FilupCheckExist extends ModelCheckerTemplateAction<FilupInfo> {	
	
	public FilupCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<FilupInfo> buildActionHook(FilupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FilupInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<FilupInfo> select = new StdFilupSelect(option);
		return select;
	}
	
	
	
	private DeciTreeOption<FilupInfo> buildOption(FilupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FilupInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_ALREADY_EXIST)
			return SystemMessage.MAT_ALREADY_EXIST;
		
		return SystemMessage.MAT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_ALREADY_EXIST;	
			
		return SystemCode.MAT_NOT_FOUND;
	}
}
