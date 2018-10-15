package br.com.gda.business.totalAmount.model.checker;

import java.sql.Connection;

import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class TotAmountCheckTwo extends ModelCheckerTemplateSimple<TotAmountInfo> {

	public TotAmountCheckTwo() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(TotAmountInfo recordInfo, Connection conn, String schemaName) {	
		//TODO: Nao implantado por nao haver previsao de uso de moeda com mais de duas casas decimais		
		
		return SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.AMOUNT_DONT_HAVE_TWO_DECIMAL_PLACES;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.AMOUNT_DONT_HAVE_TWO_DECIMAL_PLACES;
	}
}
