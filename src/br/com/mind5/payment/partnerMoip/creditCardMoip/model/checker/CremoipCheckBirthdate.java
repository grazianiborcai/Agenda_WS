package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckBirthdate extends ModelCheckerTemplateSimple_<CremoipInfo> {

	public CremoipCheckBirthdate() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		
		return isDateValid(recordInfo.birthdateHolder);
	}
	
	
	
	private boolean isDateValid(String birthdate) {
		try {
			LocalDate.parse(birthdate, DateTimeFormatter.ISO_LOCAL_DATE);
			return super.SUCCESS;
			
		} catch (Exception e) {
			return super.FAILED;
		}
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.PAY_CUS_MOIP_USERAP_MISSING;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.PAY_CUS_MOIP_USERAP_MISSING;
	}
}
