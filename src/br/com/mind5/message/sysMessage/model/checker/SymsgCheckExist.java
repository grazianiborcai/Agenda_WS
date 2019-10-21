package br.com.mind5.message.sysMessage.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.action.StdSymsgSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgCheckExist extends ModelCheckerTemplateAction_<SymsgInfo> {
	
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
			return SystemCode.SYS_MESSAGE_ALREADY_EXIST;	
			
		return SystemCode.SYS_MESSAGE_NOT_FOUND;
	}
}
