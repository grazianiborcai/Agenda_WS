package br.com.gda.business.schedule.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.action.StdScheduSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderemCheckExist extends ModelCheckerTemplateAction<ScheduInfo> {
	
	public OrderemCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<ScheduInfo> buildActionHook(ScheduInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<ScheduInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<ScheduInfo> actionSelect = new StdScheduSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<ScheduInfo> buildActionOption(ScheduInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<ScheduInfo> option = new DeciTreeOption<>();
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
