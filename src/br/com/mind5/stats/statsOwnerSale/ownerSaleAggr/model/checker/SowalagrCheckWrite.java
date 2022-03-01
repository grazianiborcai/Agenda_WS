package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrCheckWrite extends ModelCheckerTemplateSimple<SowalagrInfo> {

	public SowalagrCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SowalagrInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codCountry 	== null ||
			recordInfo.codState 	== null ||
			recordInfo.city 		== null ||
			recordInfo.username 	== null ||
			recordInfo.codLanguage 	== null		)	
			
			return super.FAILED;
			
			
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_OWN_SALE_AGGR_MANDATORY_FIELD_EMPTY;
	}
}
