package br.com.mind5.discount.discountStore.model.checker;

import java.sql.Connection;
import java.time.LocalDateTime;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemCode;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class DisoreCheckIsActive extends ModelCheckerTemplateSimple<DisoreInfo> {

	public DisoreCheckIsActive(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(DisoreInfo recordInfo, Connection conn, String schemaName) {			
		if (isActive(recordInfo) == false)
			return super.FAILED;
		
		if (isValidFrom(recordInfo) == false)
			return super.FAILED;
		
		if (isValidTo(recordInfo) == false)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isActive(DisoreInfo recordInfo) {
		return recordInfo.isActive;
	}
	
	
	
	private boolean isValidFrom(DisoreInfo recordInfo) {
		LocalDateTime now = DefaultValue.localDateTimeNow();
		
		if (recordInfo.validFrom == null)
			return super.FAILED;
		
		if (recordInfo.validFrom.isAfter(now))
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isValidTo(DisoreInfo recordInfo) {
		LocalDateTime now = DefaultValue.localDateTimeNow();
		
		if (recordInfo.validTo == null)
			return super.FAILED;
		
		if (recordInfo.validTo.isBefore(now))
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DISCOUNT_STORE_IS_INVALID;
	}
}
