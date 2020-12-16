package br.com.mind5.stats.userStoreStgn.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.orderStatus.info.Orderatus;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

public final class StusorageCheckOrderStatus extends ModelCheckerTemplateSimple<StusorageInfo> {

	public StusorageCheckOrderStatus(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StusorageInfo recordInfo, Connection conn, String schemaName) {	
		if (isStatusNull(recordInfo))			
			return super.FAILED;
		
		if (isOrderPaid(recordInfo))			
			return super.SUCCESS;
		
		if (isOrderRefunding(recordInfo))			
			return super.SUCCESS;
		
		if (isOrderCancelled(recordInfo))			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	private boolean isStatusNull(StusorageInfo recordInfo) {
		if (recordInfo.codOrderStatus == null)			
			return super.FAILED;
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isOrderPaid(StusorageInfo recordInfo) {
		if (recordInfo.codOrderStatus.equals(Orderatus.PAID.getCodStatus()))			
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isOrderRefunding(StusorageInfo recordInfo) {
		if (recordInfo.codOrderStatus.equals(Orderatus.REFUNDING.getCodStatus()))			
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	private boolean isOrderCancelled(StusorageInfo recordInfo) {
		if (recordInfo.codOrderStatus.equals(Orderatus.CANCELLED.getCodStatus()))			
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STAT_STORE_USER_STGN_MANDATORY_FIELD_EMPTY;
	}
}
