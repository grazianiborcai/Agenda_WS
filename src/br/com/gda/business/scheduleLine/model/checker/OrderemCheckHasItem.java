package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineSelect;
import br.com.gda.business.scheduleLine.model.action.StdOrderemEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrderemCheckHasItem extends ModelCheckerTemplateAction<SchedineInfo> {
	
	public OrderemCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<SchedineInfo> buildActionHook(SchedineInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SchedineInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SchedineInfo> actionSelect = new StdOrderemEnforceKey(option);
		actionSelect.addPostAction(new LazySchedineSelect(conn, schemaName));
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
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_HAVE_ITEM)
			return SystemMessage.ORDER_HAVE_ITEM;
		
		return SystemMessage.ORDER_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_HAVE_ITEM;	
		
		return SystemCode.ORDER_IS_EMPTY;
	}
}
