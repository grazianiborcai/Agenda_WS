package br.com.mind5.payment.partnerMoip.creditCardMoip.model.checker;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class CremoipCheckBirthdate extends ModelCheckerTemplateSimpleV2<CremoipInfo> {

	public CremoipCheckBirthdate(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CremoipInfo recordInfo, Connection conn, String schemaName) {	
		
		if (recordInfo.birthdateHolder == null)
			return super.FAILED;
		
		
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
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_MOIP_MISSING_BIRTHDATE;
	}	
}
