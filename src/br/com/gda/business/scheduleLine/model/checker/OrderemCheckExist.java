package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.StdSchedineSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderemCheckExist extends ModelCheckerTemplateAction<SchedineInfo> {
	
	public OrderemCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<SchedineInfo> buildActionHook(SchedineInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SchedineInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SchedineInfo> actionSelect = new StdSchedineSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<SchedineInfo> buildActionOption(SchedineInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SchedineInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_ITEM_ALREADY_EXIST)
			return SystemMessage.ORDER_ITEM_ALREADY_EXIST;
		
		return SystemMessage.ORDER_ITEM_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_ITEM_ALREADY_EXIST;	
		
		return SystemCode.ORDER_ITEM_NOT_FOUND;
	}
}
