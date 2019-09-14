package br.com.gda.message.sysMessage.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.model.action.StdSymsgSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class SymsgCheckExist extends ModelCheckerTemplateAction<SymsgInfo> {
	
	public SymsgCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<SymsgInfo> buildActionHook(SymsgInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SymsgInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<SymsgInfo> select = new StdSymsgSelect(option);
		return select;
	}
	
	
	
	private DeciTreeOption<SymsgInfo> buildOption(SymsgInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SymsgInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.SYS_MESSAGE_ALREADY_EXIST)
			return SystemMessage.SYS_MESSAGE_ALREADY_EXIST;
		
		return SystemMessage.SYS_MESSAGE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.STORE_ALREADY_EXIST;	
			
		return SystemCode.STORE_NOT_FOUND;
	}
}
