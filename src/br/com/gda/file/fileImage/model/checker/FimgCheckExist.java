package br.com.gda.file.fileImage.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.StdFimgSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgCheckExist extends ModelCheckerTemplateAction<FimgInfo> {	
	
	public FimgCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<FimgInfo> buildActionHook(FimgInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FimgInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<FimgInfo> select = new StdFimgSelect(option);
		return select;
	}
	
	
	
	private DeciTreeOption<FimgInfo> buildOption(FimgInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FimgInfo> option = new DeciTreeOption<>();
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
