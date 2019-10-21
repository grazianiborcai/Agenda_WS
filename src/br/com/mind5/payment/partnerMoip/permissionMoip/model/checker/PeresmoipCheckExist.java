package br.com.mind5.payment.partnerMoip.permissionMoip.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree.RootPeresmoipSelect;

public final class PeresmoipCheckExist extends ModelCheckerTemplateAction_<PeresmoipInfo> {
	
	public PeresmoipCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<PeresmoipInfo> buildActionHook(PeresmoipInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PeresmoipInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PeresmoipInfo> select = new RootPeresmoipSelect(option).toAction();
		return select;
	}
	
	
	
	private DeciTreeOption<PeresmoipInfo> buildActionOption(PeresmoipInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PeresmoipInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MOIP_PERM_RESP_ALREADY_EXIST)
			return SystemMessage.MOIP_PERM_RESP_ALREADY_EXIST;
		
		return SystemMessage.MOIP_PERM_RESP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MOIP_PERM_RESP_ALREADY_EXIST;	
			
		return SystemCode.MOIP_PERM_RESP_NOT_FOUND;
	}
}
