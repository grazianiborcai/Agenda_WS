package br.com.mind5.payment.systemPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.info.SysparInfo;
import br.com.mind5.payment.systemPartner.model.decisionTree.RootSysparSelect;

public final class SysparCheckExist extends ModelCheckerTemplateAction_<SysparInfo> {
	
	public SysparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<SysparInfo> buildActionHook(SysparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SysparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<SysparInfo> select = new RootSysparSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<SysparInfo> buildActionOption(SysparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<SysparInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.SYS_PAY_PARTNER_ALREADY_EXIST)
			return SystemMessage.SYS_PAY_PARTNER_ALREADY_EXIST;
		
		return SystemMessage.SYS_PAY_PARTNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_COUNTRY_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_COUNTRY_NOT_FOUND;
	}
}
