package br.com.gda.business.orderSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.model.action.LazyOrdnapSelect;
import br.com.gda.business.orderSnapshot.model.action.StdOrdnapEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class OrdnapCheckExist extends ModelCheckerTemplateAction<OrdnapInfo> {
	
	public OrdnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<OrdnapInfo> buildActionHook(OrdnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrdnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<OrdnapInfo> enforceKey = new StdOrdnapEnforceKey(option);	
		ActionLazy<OrdnapInfo> select = new LazyOrdnapSelect(conn, schemaName);
		
		enforceKey.addPostAction(select);
		
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<OrdnapInfo> buildActionOption(OrdnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<OrdnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.ORDER_HEADER_SNAP_ALREADY_EXIST)
			return SystemMessage.ORDER_HEADER_SNAP_ALREADY_EXIST;
		
		return SystemMessage.ORDER_HEADER_SNAP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.ORDER_HEADER_SNAP_ALREADY_EXIST;	
		
		return SystemCode.ORDER_HEADER_SNAP_NOT_FOUND;
	}
}
